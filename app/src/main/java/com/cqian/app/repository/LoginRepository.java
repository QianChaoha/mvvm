package com.cqian.app.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;

import com.cqian.app.bean.TokenBean;
import com.cqian.app.repository.remote.ProjectApi;
import com.cqian.app.repository.remote.RemoteProjectDataSource;
import com.cqian.app.repository.remote.RetrofitFactory;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by 86839 on 2017/10/6.
 */

public class LoginRepository {
    private static final LoginRepository instance = new LoginRepository();
    private LoginRepository() {
    }
    public static LoginRepository getInstance() {
        return instance;
    }


    private Context context;
    private ProjectDataSource remoteProjectDataSource = RemoteProjectDataSource.getInstance();
    //private ProjectDataSource localProjectDataSource = LocalProjectDataSource.getInstance();

    public void init(Context context) {
        this.context = context.getApplicationContext();
    }

    public MutableLiveData<TokenBean> getToken() {
//        if (NetworkUtils.isConnected(context)) {
//            return remoteProjectDataSource.queryProjects(page);
//        } else {
//            return localProjectDataSource.queryProjects(page);
//        }
//        ProjectApi projectApi = RetrofitFactory.getInstance().create(ProjectApi.class);
//        JSONObject jsonObject = new JSONObject();
//        try {
//            jsonObject.put("phone", mEtUser.getText().toString());
//            jsonObject.put("passwd", mEtPassword.getText().toString());
//            // 国家简码 "CN"
//            if (LanguageUtils.currentLaguageIsZh(mActivity)) {
//                jsonObject.put("language", LanguageUtils.CN);
//            } else {
//                jsonObject.put("language", LanguageUtils.EN);
//            }
//
//            // 国家代码 86
//            jsonObject.put("dialing_code", mDataBean.ncode);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        projectApi.login()
        return remoteProjectDataSource.getToken();
    }

}
