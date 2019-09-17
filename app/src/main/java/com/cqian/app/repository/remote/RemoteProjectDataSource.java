package com.cqian.app.repository.remote;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.cqian.app.bean.TokenBean;
import com.cqian.app.repository.ProjectDataSource;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by 86839 on 2017/10/6.
 */

public class RemoteProjectDataSource implements ProjectDataSource {
    private static final RemoteProjectDataSource instance = new RemoteProjectDataSource();

    private RemoteProjectDataSource() {
    }

    public static RemoteProjectDataSource getInstance() {
        return instance;
    }


    private ProjectApi projectApi = RetrofitFactory.getInstance().create(ProjectApi.class);

    @Override
    public MutableLiveData<TokenBean> getToken() {
        final MutableLiveData<TokenBean> data = new MutableLiveData<TokenBean>();
        projectApi.login().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseBean<List<PublicNumberBean>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseBean<List<PublicNumberBean>> listBaseBean) {
                        if (listBaseBean !=null){
                            data.setValue(listBaseBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        data.setValue(null);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        return data;
    }
}
