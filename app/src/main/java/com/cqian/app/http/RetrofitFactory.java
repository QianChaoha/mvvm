package com.cqian.app.http;

import com.cqian.app.http.cache.EnhancedCacheInterceptor;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yu on 2017/2/21.
 */

public class RetrofitFactory {
    private static Retrofit retrofit;
    private static String mToken;//token值

    static {
        retrofit = new Retrofit.Builder()
                .baseUrl(HttpUrl.SERVER_URL)
                .client(getClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Retrofit getInstance() {
        return retrofit;
    }

    public static OkHttpClient getClient() {

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(new EnhancedCacheInterceptor())
                .addInterceptor(new Interceptor() {

                    @Override

                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request()
                                .newBuilder()
                                .addHeader("device-type", "Mobile")
                                .addHeader("Authorization", "Bearer " + getToken())
                                .build();

                        return chain.proceed(request);
                    }

                })

                .build();

        return httpClient;

    }

    public static String getToken() {
        return mToken;
    }

    public static void setToken(String token) {
        mToken = token;
    }
}
