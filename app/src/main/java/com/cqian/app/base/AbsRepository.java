package com.cqian.app.base;



import android.arch.lifecycle.MutableLiveData;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author：tqzhang on 18/7/26 16:15
 * Disposable用来解除订阅,CompositeDisposable是一个disposable的容器，可以容纳多个disposable，
 * 可以创建一个BaseActivity，用CompositeDisposable来管理订阅事件disposable，
 * 然后在acivity销毁的时候，调用compositeDisposable.dispose()就可以切断所有订阅事件，防止内存泄漏
 */
public abstract class AbsRepository {

    private CompositeDisposable mCompositeDisposable;

    public MutableLiveData<String> loadState;


    public AbsRepository() {
        loadState = new MutableLiveData<>();
    }

    protected void postState(String state) {
        if (loadState != null) {
            loadState.postValue(state);
        }

    }


    protected void addDisposable(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }

    public void unDisposable() {
        if (mCompositeDisposable != null && mCompositeDisposable.isDisposed()) {
            mCompositeDisposable.clear();
        }
    }
}
