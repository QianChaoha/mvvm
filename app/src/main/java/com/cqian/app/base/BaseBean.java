package com.cqian.app.base;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.io.Serializable;

/**
 * Created by hellojbi on 2017/10/26.
 * 基础实体类
 */

public class BaseBean implements Serializable, Subscriber {


    /**
     * result : success/error
     * errorcode : 200, 200:成功  201:网络异常,请稍后再试!
     * message : 操作成功!
     */

    public String errcode;
    public String msg;

    public boolean isSuccess() {
        return "0".equals(errcode);
    }

    @Override
    public void onSubscribe(Subscription s) {

    }

    @Override
    public void onNext(Object o) {

    }

    @Override
    public void onError(Throwable t) {

    }

    @Override
    public void onComplete() {

    }
}
