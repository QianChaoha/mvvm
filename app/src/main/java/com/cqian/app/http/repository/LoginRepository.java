package com.cqian.app.http.repository;

import android.arch.lifecycle.MutableLiveData;
import android.content.Context;

import com.cqian.app.base.BaseRepository;
import com.cqian.app.bean.LoginBean;
import com.cqian.app.http.rx.RxSchedulers;
import com.cqian.app.http.rx.RxSubscriber;


/**
 * Created by 86839 on 2017/10/6.
 */

public class LoginRepository extends BaseRepository {
    private static final LoginRepository instance = new LoginRepository();

    private LoginRepository() {
    }

    public static LoginRepository getInstance() {
        return instance;
    }


    private Context context;

    public void init(Context context) {
        this.context = context.getApplicationContext();
    }

    public MutableLiveData<LoginBean> login(String userName, String passWord) {
        final MutableLiveData<LoginBean> data = new MutableLiveData<>();
        addDisposable(mApiService.login(userName, passWord)
                .compose(RxSchedulers.ioToMain())
                .subscribeWith(new RxSubscriber<LoginBean>() {

                    @Override
                    protected void onNoNetWork() {
                        super.onNoNetWork();
                    }

                    @Override
                    public void onSuccess(LoginBean worksListVo) {
                        //postData(EVENT_KEY_WORK_MORE, worksListVo);
                    }

                    @Override
                    public void onFailure(String msg,int code) {
                    }
                }));
        return data;
    }

}
