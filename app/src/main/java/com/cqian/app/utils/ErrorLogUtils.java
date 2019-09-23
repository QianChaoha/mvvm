package com.cqian.app.utils;

import android.content.Context;
import android.text.TextUtils;

import com.cqian.baselibrary.utils.ToastUtils;

import java.lang.ref.SoftReference;


/**
 * Description:
 * Data: 2018/7/24
 *
 * @author: cqian
 */

public class ErrorLogUtils {

    public static void showError(Context context, String messsge, String code) {
        SoftReference<Context> softReference = new SoftReference<Context>(context);
        if (softReference.get() != null && (!TextUtils.isEmpty(code))) {
            ToastUtils.showToast(softReference.get(), code);
        }
    }

}
