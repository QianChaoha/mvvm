package com.cqian.app.http;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import com.cqian.mvvm.base.BaseBean;

public abstract class HttpObserver<T extends BaseBean> implements Observer<T> {
    @Override
    public void onChanged(@Nullable T data) {
        if (data != null) {
            if (data.isSuccess()) {
                onSuccess(data);
            } else {
                onFailed(data.msg, data.errorCode);
            }
        }
        finishRefresh();
    }

    public abstract void onSuccess(T data);

    public abstract void onFailed(String msg, String errCode);

    public abstract void finishRefresh();
}
