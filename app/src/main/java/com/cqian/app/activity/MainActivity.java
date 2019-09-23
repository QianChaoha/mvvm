package com.cqian.app.activity;

import com.cqian.app.R;
import com.cqian.app.bean.BannerBean;
import com.cqian.app.databinding.ActivityMainBinding;
import com.cqian.app.http.HttpObserver;
import com.cqian.app.utils.ErrorLogUtils;
import com.cqian.app.utils.GlideImageLoader;
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
        showLoading();
        mViewModel.getBanner().observe(this, new HttpObserver<BannerBean>() {
            @Override
            public void onSuccess(BannerBean data) {
                mBindingView.banner.setImages(data.getImagePathList()).setImageLoader(new GlideImageLoader()).start();
            }

            @Override
            public void onFailed(String msg, String errCode) {
                ErrorLogUtils.showError(mActivity, msg, errCode);
            }

            @Override
            public void finishRefresh() {
                dismissLoading();
            }
        });
    }
}
