package com.eternity_myth.gank.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.eternity_myth.gank.presenter.BasePresenter;

public abstract class BaseMvpActivity<V, P extends BasePresenter> extends
        AppCompatActivity {
    public P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = initPresenter();
        presenter.attach((V) this);
    }

    ///================等待实现的方法集合==========================
    public abstract void initVariables();//初始化变量,包括Intent带的数据和Activity内的变量

    public abstract void initViews(); // 加载layout布局文件,初始化控件


    protected abstract P initPresenter();

    @Override
    protected void onDestroy() {
        presenter.dettach();
        super.onDestroy();
    }
}