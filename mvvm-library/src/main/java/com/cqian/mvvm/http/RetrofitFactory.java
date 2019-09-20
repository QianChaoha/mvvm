package com.cqian.mvvm.http;

import com.cqian.mvvm.http.cache.EnhancedCacheInterceptor;

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

    public static void init(String baseUrl) {
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
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
                                .build();

                        return chain.proceed(request);
                    }

                })

                .build();

        return httpClient;

    }

}
