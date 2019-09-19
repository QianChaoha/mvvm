package com.cqian.app;

import android.app.Application;
import android.content.Context;

/**
 * Description:
 * Date: 2019/9/18
 *
 * @author: cqian
 */
public class AppApplication extends Application {
    public static Context mAppContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppContext = this;
    }
}
