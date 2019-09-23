package com.cqian.app.activity;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import com.cqian.app.R;
import com.cqian.app.bean.BannerBean;
import com.cqian.app.bean.LoginBean;
import com.cqian.app.databinding.ActivityMainBinding;
import com.cqian.app.viewmodel.MainViewModel;
import com.cqian.mvvm.base.BaseMvvmActivity;

/**
 * Description:
 * Date: 2019/9/8
 *
 * @author: cqian
 */
public class MainActivity extends BaseMvvmActivity<MainViewModel, ActivityMainBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initTitle() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        mViewModel.getBanner().observe(this, new Observer<BannerBean>() {
            @Override
            public void onChanged(@Nullable BannerBean bannerBean) {

            }
        });
    }
}
