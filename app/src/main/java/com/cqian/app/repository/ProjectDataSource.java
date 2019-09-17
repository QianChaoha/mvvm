package com.cqian.app.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.cqian.app.bean.TokenBean;

/**
 * Created by 86839 on 2017/10/6.
 */

public interface ProjectDataSource {
    //获取token
    MutableLiveData<TokenBean> getToken();

}
