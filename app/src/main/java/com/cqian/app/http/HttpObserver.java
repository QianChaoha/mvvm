package com.cqian.app.http;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import com.cqian.app.base.BaseBean;

public abstract class HttpObserver<T extends BaseBean> implements Observer<T> {
    @Override
    public void onChanged(@Nullable T data) {
        if (data != null) {
            if (data.isSuccess()){
                onSuccess(data);
            }else {
                onFailed(data.errcode,data.msg);
            }
        }
    }

    public abstract void onSuccess(T data);

    public abstract void onFailed(String errCode, String msg);
}
