package com.cqian.mvvm.base;

import android.app.Activity;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.cqian.baselibrary.base.BaseFragment;
import com.cqian.mvvm.R;
import com.cqian.mvvm.utils.ClassUtil;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Description:
 * Date: 2019/9/7
 *
 * @author: cqian
 */
public abstract class BaseMvvmFragment<VM extends AndroidViewModel, SV extends ViewDataBinding> extends BaseFragment {
    // ViewModel
    protected VM mViewModel;
    // 布局view
    protected SV mBindingView;
    // 加载中
    private View loadingView;
    // 加载失败
    private View errorView;
    // 空布局
    private View emptyView;
    // 动画
    private AnimationDrawable mAnimationDrawable;
    private CompositeDisposable mCompositeDisposable;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_base, null);
        //实例化子类布局
        mBindingView = DataBindingUtil.inflate(mActivity.getLayoutInflater(), setContent(), null, false);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mBindingView.getRoot().setLayoutParams(params);

        //将子类布局加到base布局的contain下
        RelativeLayout mContainer = inflate.findViewById(R.id.container);
        mContainer.addView(mBindingView.getRoot());
        return inflate;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadingView = ((ViewStub) mActivity.findViewById(R.id.vs_loading)).inflate();
        ImageView img = loadingView.findViewById(R.id.img_progress);

        // 加载动画
        mAnimationDrawable = (AnimationDrawable) img.getDrawable();
        // 默认进入页面就开启动画
        if (!mAnimationDrawable.isRunning()) {
            mAnimationDrawable.start();
        }
        mBindingView.getRoot().setVisibility(View.GONE);
        initViewModel();
    }
    /**
     * 初始化ViewModel
     */
    private void initViewModel() {
        Class<VM> viewModelClass = ClassUtil.getViewModel(this);
        if (viewModelClass != null) {
            this.mViewModel = ViewModelProviders.of(this).get(viewModelClass);
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (this.mCompositeDisposable != null && !mCompositeDisposable.isDisposed()) {
            this.mCompositeDisposable.clear();
        }
    }

    public void removeDisposable() {
        if (this.mCompositeDisposable != null && !mCompositeDisposable.isDisposed()) {
            this.mCompositeDisposable.dispose();
        }
    }

    /**
     * 布局
     */
    public abstract int setContent();
}
