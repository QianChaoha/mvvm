package com.cqian.app.http.repository;

import android.arch.lifecycle.MutableLiveData;

import com.cqian.app.base.BaseRepository;
import com.cqian.app.bean.BannerBean;
import com.cqian.app.bean.LoginBean;
import com.cqian.mvvm.http.rx.RxSchedulers;
import com.cqian.mvvm.http.rx.RxSubscriber;


/**
 * Created by 86839 on 2017/10/6.
 */

public class MainRepository extends BaseRepository {
    private static final MainRepository mInstance = new MainRepository();

    private MainRepository() {
    }

    public static MainRepository getInstance() {
        return mInstance;
    }

    public MutableLiveData<BannerBean> getBanner() {
        final MutableLiveData<BannerBean> data = new MutableLiveData<>();
        addDisposable(mApiService.getBanner()
                .compose(RxSchedulers.ioToMain())
                .subscribeWith(new RxSubscriber<BannerBean>() {

                    @Override
                    protected void onNoNetWork() {
                        super.onNoNetWork();
                    }

                    @Override
                    public void onSuccess(BannerBean bannerBean) {
                        data.setValue(bannerBean);
                    }

                    @Override
                    public void onFailure(String msg, String code) {
                       // data.setValue(new BannerBean());
                    }
                }));
        return data;
    }

}
