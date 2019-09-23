package com.cqian.app.http.repository;

import android.arch.lifecycle.MutableLiveData;

import com.cqian.app.base.BaseRepository;
import com.cqian.app.bean.ArticleBean;
import com.cqian.app.bean.BannerBean;
import com.cqian.app.bean.LoginBean;
import com.cqian.mvvm.http.rx.RxSchedulers;
import com.cqian.mvvm.http.rx.RxSubscriber;

import java.util.ArrayList;
import java.util.List;


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
        mApiService.getBanner()
                .compose(RxSchedulers.ioToMain())
                .subscribeWith(new RxSubscriber<BannerBean>() {

                    @Override
                    public void onCallBack(BannerBean bannerBean) {
                        if (bannerBean != null && bannerBean.getData() != null && bannerBean.getData().size() > 0) {
                            List<String> imagePathList = new ArrayList<String>();
                            for (int i = 0; i < bannerBean.getData().size() && bannerBean.getData().get(i) != null; i++) {
                                imagePathList.add(bannerBean.getData().get(i).getImagePath());
                            }
                            bannerBean.setImagePathList(imagePathList);
                        }
                        data.setValue(bannerBean);
                    }
                });
        return data;
    }

    public MutableLiveData<ArticleBean> getHomeData() {
        final MutableLiveData<ArticleBean> data = new MutableLiveData<>();
        mApiService.getArticle()
                .compose(RxSchedulers.ioToMain())
                .subscribeWith(new RxSubscriber<ArticleBean>() {

                    @Override
                    public void onCallBack(ArticleBean bannerBean) {
                    }
                });
        return data;
    }


}
