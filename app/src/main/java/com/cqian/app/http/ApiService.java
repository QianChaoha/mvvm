package com.cqian.app.http;

import com.cqian.app.bean.ArticleBean;
import com.cqian.app.bean.BannerBean;
import com.cqian.app.bean.LoginBean;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Description:
 * Date: 2019/9/11
 *
 * @author: cqian
 */
public interface ApiService {
    @POST(HttpUrl.LOGIN)
    @FormUrlEncoded
    Flowable<LoginBean> login(@Field("username") String userName, @Field("password") String passWord);
    @POST(HttpUrl.BANNER)
    Flowable<BannerBean> getBanner();
    @POST(HttpUrl.ARTICLE)
    Flowable<ArticleBean> getArticle();
}
