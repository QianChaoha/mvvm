package com.cqian.app.http;

import com.cqian.app.base.BaseBean;
import com.cqian.mvvm.http.rx.RxSubscriber;

public abstract class HttpRxSubscriber<T extends BaseBean> extends RxSubscriber<T> {

    @Override
    public void onFailure(String msg, String code) {

    }
}
