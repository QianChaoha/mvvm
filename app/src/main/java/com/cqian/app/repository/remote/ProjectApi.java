package com.cqian.app.repository.remote;


import io.reactivex.Flowable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by 86839 on 2017/10/6.
 */

public interface ProjectApi {
    @POST(HttpUrl.LOGIN)
    Flowable<ResponseBody> login(@Body RequestBody info);   // 请求体味RequestBody 类型
}
