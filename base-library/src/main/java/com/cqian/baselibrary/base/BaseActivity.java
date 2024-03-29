package com.cqian.baselibrary.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;


/**
 * Description:
 * Data: 2019/3/27
 *
 * @author: cqian
 */
public abstract class BaseActivity extends FragmentActivity {
    public View mRootView;
    protected View mLayoutView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        beforeAddContent();
        super.onCreate(savedInstanceState);
        afterSuperCreate();
        mRootView = getWindow().getDecorView().getRootView();
        mLayoutView = View.inflate(this, getLayoutId(), null);
        setContentView(mLayoutView);
        initTitle();
        initView();
        initData();
    }

    public void start(Class clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    protected abstract int getLayoutId();

    protected abstract void initTitle();

    protected abstract void initView();

    protected abstract void initData();

    protected void beforeAddContent() {
    }

    protected void afterSuperCreate() {
    }

}
