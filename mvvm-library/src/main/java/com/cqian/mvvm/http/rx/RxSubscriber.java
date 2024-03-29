package com.cqian.mvvm.http.rx;


import com.cqian.mvvm.BaseApplication;
import com.cqian.mvvm.base.BaseBean;
import com.cqian.mvvm.http.ServerException;
import com.cqian.baselibrary.utils.NetworkUtils;
import com.cqian.baselibrary.utils.ToastUtils;
import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.lang.reflect.ParameterizedType;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import io.reactivex.subscribers.DisposableSubscriber;
import retrofit2.HttpException;

/**
 * @author tqzhang
 */
public abstract class RxSubscriber<T extends BaseBean> extends DisposableSubscriber<T> {


    public RxSubscriber() {
        super();
    }

    @Override
    protected void onStart() {
        super.onStart();
        showLoading();
        if (!NetworkUtils.isNetworkOnline(BaseApplication.mAppContext)) {
            onNoNetWork();
            cancel();
            ToastUtils.showToast(BaseApplication.mAppContext,"网络状态异常");
            return;
        }
    }


    @Override
    public void onComplete() {

    }

    protected void showLoading() {

    }

    protected void showProgress() {

    }

    protected void onNoNetWork() {

    }

    @Override
    public void onError(Throwable e) {
        String message;
        int code = -1;
        if (e instanceof UnknownHostException) {
            message = "没有网络";
        } else if (e instanceof HttpException) {
            message = "网络错误";
        } else if (e instanceof SocketTimeoutException) {
            message = "网络连接超时";
        } else if (e instanceof JsonParseException
                || e instanceof JSONException) {
            message = "解析错误";
        } else if (e instanceof ConnectException) {
            message = "连接失败";
        } else if (e instanceof ServerException) {
            message = ((ServerException) e).message;
            code = ((ServerException) e).code;
        } else {
            message = "未知错误";
        }
        onFailure(message, code+"");
    }

    @Override
    public void onNext(T t) {
        onCallBack(t);
    }

    public void onFailure(String msg, String code) {
        Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        try {
            T t = entityClass.newInstance();
            t.msg = msg;
            t.errorCode = code;
            onCallBack(t);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public abstract void onCallBack(T t);
}
