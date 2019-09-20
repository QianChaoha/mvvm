package com.cqian.app;

import com.cqian.app.http.HttpUrl;
import com.cqian.mvvm.BaseApplication;
import com.cqian.mvvm.http.RetrofitFactory;

public class AppApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitFactory.init(HttpUrl.SERVER_URL);
    }
}
