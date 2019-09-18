package com.cqian.baselibrary.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Description:
 * Date: 2019/9/10
 *
 * @author: cqian
 */
public class ToastUtils {
    public static void showToast(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_LONG);
    }
}
