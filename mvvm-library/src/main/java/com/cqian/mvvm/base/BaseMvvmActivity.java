package com.cqian.mvvm.base;

import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.cqian.mvvm.R;
import com.cqian.mvvm.databinding.ActivityBaseBinding;
import com.cqian.mvvm.utils.ClassUtils;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author jingbin
 * @date 16/12/10
 */
public abstract class BaseMvvmActivity<VM extends AndroidViewModel, SV extends ViewDataBinding> extends AppCompatActivity {

    // ViewModel
    protected VM mViewModel;
    // 布局view
    protected SV mBindingView;
    private View errorView;
    private View loadingView;
    private ActivityBaseBinding mBaseBinding;
    private AnimationDrawable mAnimationDrawable;
    private CompositeDisposable mCompositeDisposable;
    protected BaseMvvmActivity mActivity;

    protected <T extends View> T getView(int id) {
        return (T) findViewById(id);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        beforeAddContent();
        super.onCreate(savedInstanceState);
        mActivity = this;
        afterSuperCreate();
        setContentView(getLayoutId());
        initTitle();
        initView();
        initData();
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        //base布局
        mBaseBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.activity_base, null, false);
        //子类传入layoutResID的布局
        mBindingView = DataBindingUtil.inflate(getLayoutInflater(), layoutResID, null, false);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mBindingView.getRoot().setLayoutParams(params);
        //将子类布局加到base布局中的mContainer
        RelativeLayout mContainer = mBaseBinding.getRoot().findViewById(R.id.container);
        mContainer.addView(mBindingView.getRoot(),0);
        getWindow().setContentView(mBaseBinding.getRoot());

        // 设置透明状态栏，兼容4.4
        //StatusBarUtil.setColor(this, CommonUtils.getColor(R.color.colorTheme), 0);
        setLoading();
        dismissLoading();
        //setToolBar();
        initViewModel();
    }

    private void setLoading() {
        if (loadingView == null) {
            loadingView = ((ViewStub) findViewById(R.id.vs_loading)).inflate();
            ImageView img = loadingView.findViewById(R.id.img_progress);

            // 动画
            mAnimationDrawable = (AnimationDrawable) img.getDrawable();
        }
    }

    /**
     * 初始化ViewModel
     */
    private void initViewModel() {
        Class<VM> viewModelClass = ClassUtils.getViewModel(this);
        if (viewModelClass != null) {
            this.mViewModel = ViewModelProviders.of(this).get(viewModelClass);
        }
    }

    /**
     * 设置titlebar
     */
//    protected void setToolBar() {
//        setSupportActionBar(mBaseBinding.toolBar);
//        ActionBar actionBar = getSupportActionBar();
//        if (actionBar != null) {
//            //去除默认Title显示
//            actionBar.setDisplayShowTitleEnabled(false);
//            actionBar.setDisplayHomeAsUpEnabled(true);
//            actionBar.setHomeAsUpIndicator(R.drawable.icon_back);
//        }
//        mBaseBinding.toolBar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                    finishAfterTransition();
//                } else {
//                    onBackPressed();
//                }
//            }
//        });
//    }
    @Override
    public void setTitle(CharSequence text) {
        //mBaseBinding.toolBar.setTitle(text);
    }

    protected void showLoading() {
        if (loadingView != null && loadingView.getVisibility() != View.VISIBLE) {
            loadingView.setVisibility(View.VISIBLE);
        }
        // 开始动画
        if (!mAnimationDrawable.isRunning()) {
            mAnimationDrawable.start();
        }
        if (errorView != null) {
            errorView.setVisibility(View.GONE);
        }
    }

    protected void dismissLoading() {
        // 停止动画
        if (mAnimationDrawable.isRunning()) {
            mAnimationDrawable.stop();
        }
        if (loadingView != null && loadingView.getVisibility() == View.VISIBLE) {
            loadingView.setVisibility(View.GONE);
        }
        if (errorView != null) {
            errorView.setVisibility(View.GONE);
        }
    }

    protected void showContentView() {
        if (loadingView != null && loadingView.getVisibility() != View.GONE) {
            loadingView.setVisibility(View.GONE);
        }
        // 停止动画
        if (mAnimationDrawable.isRunning()) {
            mAnimationDrawable.stop();
        }
        if (errorView != null) {
            errorView.setVisibility(View.GONE);
        }
        if (mBindingView.getRoot().getVisibility() != View.VISIBLE) {
            mBindingView.getRoot().setVisibility(View.VISIBLE);
        }
    }

    protected void showError() {
        if (loadingView != null && loadingView.getVisibility() != View.GONE) {
            loadingView.setVisibility(View.GONE);
        }
        // 停止动画
        if (mAnimationDrawable.isRunning()) {
            mAnimationDrawable.stop();
        }
        if (errorView == null) {
            ViewStub viewStub = (ViewStub) findViewById(R.id.vs_error_refresh);
            errorView = viewStub.inflate();
            // 点击加载失败布局
            errorView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showLoading();
                    onRefresh();
                }
            });
        } else {
            errorView.setVisibility(View.VISIBLE);
        }
        if (mBindingView.getRoot().getVisibility() != View.GONE) {
            mBindingView.getRoot().setVisibility(View.GONE);
        }
    }

    /**
     * 失败后点击刷新
     */
    protected void onRefresh() {

    }

    public void addSubscription(Disposable s) {
        if (this.mCompositeDisposable == null) {
            this.mCompositeDisposable = new CompositeDisposable();
        }
        this.mCompositeDisposable.add(s);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.fontScale != 1) {
            getResources();
        }
    }

    /**
     * 禁止改变字体大小
     */
    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        Configuration config = new Configuration();
        config.setToDefaults();
        res.updateConfiguration(config, res.getDisplayMetrics());
        return res;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (this.mCompositeDisposable != null && !mCompositeDisposable.isDisposed()) {
            // clear 和 dispose的区别是：  disposed = true;
            this.mCompositeDisposable.clear();
        }
    }

    public void removeDisposable() {
        if (this.mCompositeDisposable != null && !mCompositeDisposable.isDisposed()) {
            this.mCompositeDisposable.dispose();
        }
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
