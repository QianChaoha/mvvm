package com.cqian.mvvm.base;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by hellojbi on 2017/10/26.
 * 基础实体类
 */

public class BaseBean implements Serializable{


    /**
     * result : success/error
     * errorcode : 200, 200:成功  201:网络异常,请稍后再试!
     * message : 操作成功!
     */

    public String errorCode;
    @SerializedName("errorMsg")
    public String msg;

    public boolean isSuccess() {
        return "0".equals(errorCode);
    }

}
