package com.cqian.app.viewmodel;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.cqian.app.bean.LoginBean;
import com.cqian.app.http.repository.LoginRepository;
import com.cqian.mvvm.base.BaseViewModel;

/**
 * Description:
 * Date: 2019/9/10
 *
 * @author: cqian
 */
public class LoginViewModel extends BaseViewModel {
    private LoginRepository mLoginRepository = LoginRepository.getInstance();

    public LoginViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<LoginBean> login(String userName, String password) {
        return mLoginRepository.login(userName,password);
    }


}
