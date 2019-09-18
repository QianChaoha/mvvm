package com.cqian.app.viewmodel;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.cqian.app.bean.TokenBean;
import com.cqian.app.repository.LoginRepository;
import com.cqian.baselibrary.utils.ToastUtil;
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

    public MutableLiveData<TokenBean> login(String userName,String password) {
        final MutableLiveData<Boolean> data = new MutableLiveData<>();


        return mLoginRepository.login(userName,password);
//        HttpClient.Builder.getWanAndroidServer().login(mUsername.get(), mPassword.get())
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<LoginBean>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        addDisposable(d);
//                    }
//
//                    @Override
//                    public void onNext(LoginBean bean) {
//                        if (bean != null && bean.getData() != null) {
//                            Injection.get().addData(bean.getData());
//                            UserUtil.handleLoginSuccess();
//                            data.setValue(true);
//                        } else {
//                            if (bean != null) {
//                                ToastUtil.showToastLong(bean.getErrorMsg());
//                            }
//                            data.setValue(false);
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        data.setValue(false);
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
    }


}
