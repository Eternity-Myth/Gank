package com.eternity_myth.gank;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.eternity_myth.gank.presenter.BasePresenter;
import com.eternity_myth.gank.view.BaseMvpActivity;
import com.eternity_myth.gank.view.TypeFragmentView;

public class MainActivity extends BaseMvpActivity<TypeFragmentView, BasePresenter<TypeFragmentView>> {

    @BindView(R.id.fl_content)
    FrameLayout flContent;
    @BindView(R.id.navigation_view)
    NavigationView navigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initVariables();
        initViews();
    }

    @Override
    public void initVariables() {
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        ActivityStackManager.getInstance().addActivity(this);
    }

    @Override
    public void initViews() {
        mFragmentTransaction.replace(R.id.fl_content, new MainFragment());
        mFragmentTransaction.commit();
    }

    @Override
    protected BasePresenter<TypeFragmentView> initPresenter() {
        return new BasePresenter<TypeFragmentView>();
    }

    @Override
    protected void onDestroy() {
        ActivityStackManager.getInstance().finishActivity();
        super.onDestroy();
    }

}


