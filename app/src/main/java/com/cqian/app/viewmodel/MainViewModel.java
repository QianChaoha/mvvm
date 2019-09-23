package com.cqian.app.viewmodel;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.cqian.app.bean.BannerBean;
import com.cqian.app.bean.LoginBean;
import com.cqian.app.http.repository.LoginRepository;
import com.cqian.app.http.repository.MainRepository;
import com.cqian.mvvm.base.BaseViewModel;

/**
 * Description:
 * Date: 2019/9/10
 *
 * @author: cqian
 */
public class MainViewModel extends BaseViewModel {
    private MainRepository mMainRepository = MainRepository.getInstance();

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<BannerBean> getBanner() {
        return mMainRepository.getBanner();
    }

}
