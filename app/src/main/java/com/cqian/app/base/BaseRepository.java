package com.cqian.app.base;

import com.cqian.app.http.ApiService;
import com.cqian.app.http.RetrofitFactory;


/**
 * @author：tqzhang on 18/7/26 16:15
 */
public class BaseRepository extends AbsRepository {

    protected ApiService mApiService;


    public BaseRepository() {
        if (null == mApiService) {
            mApiService = RetrofitFactory.getInstance().create(ApiService.class);
        }
    }

//
//    protected void postData(Object eventKey, Object t) {
//        postData(eventKey, null, t);
//    }
//
//
//    protected void showPageState(Object eventKey, String state) {
//        postData(eventKey, state);
//    }
//
//    protected void showPageState(Object eventKey, String tag, String state) {
//        postData(eventKey, tag, state);
//    }

//    protected void postData(Object eventKey, String tag, Object t) {
//        LiveBus.getDefault().postEvent(eventKey, tag, t);
//    }

}
