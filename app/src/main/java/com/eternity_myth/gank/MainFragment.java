package com.eternity_myth.gank;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.*;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.eternity_myth.gank.adapter.GankViewPagerAdapter;
import com.eternity_myth.gank.presenter.BasePresenter;
import com.eternity_myth.gank.view.BaseMvpFragment;

import com.eternity_myth.gank.view.TypeFragmentView;
import rx.Observable;
import rx.functions.Action1;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends BaseMvpFragment<TypeFragmentView, BasePresenter<TypeFragmentView>> {
    private String TAG = getClass().getSimpleName();
    @BindView(R.id.toolbar_tabbar)
    Toolbar toolbarTabbar;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    private View rootView;
    private List<String> mTitles;
    private List<Fragment> mFragments;
    private GankViewPagerAdapter fragmentAdapter;

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTitles = new ArrayList<>();
        mFragments = new ArrayList<>();
        initVariables();
    }

    @Override
    public void initVariables() {
        // 在默认线程中添加保持同步
        Observable.just("all", "Android", "iOS", "前端", "福利")
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        mTitles.add(s);
                        mFragments.add(TypeFragment.newInstance(s));
                        Log.e(TAG, Thread.currentThread().getName());

                    }
                });
        fragmentAdapter = new GankViewPagerAdapter(getChildFragmentManager(), mFragments, mTitles);
    }

    @Override
    public void initViews() {
        toolbarTabbar.setTitle("GankIO");
        viewPager.setAdapter(fragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected BasePresenter<TypeFragmentView> initPresenter() {
        return new BasePresenter<TypeFragmentView>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, rootView);
        initViews();
        return rootView;
    }

}
