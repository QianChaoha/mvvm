package com.cqian.app.bean;

import com.cqian.app.base.BaseBean;

/**
 * Description:
 * Data: 2018/8/15
 *
 * @author: cqian
 */
public class LoginBean  {

    /**
     * data : {"token":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwiZXhwIjoxNTM2MTEzMDQ5fQ.7_9UrFVRDQEfxmHQfc7L8w1jwbcLHoZOGF7UkuUGfCA"}
     */

    public DataBean data;

    public class DataBean {
        /**
         * token : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwiZXhwIjoxNTM2MTEzMDQ5fQ.7_9UrFVRDQEfxmHQfc7L8w1jwbcLHoZOGF7UkuUGfCA
         */
        public String token;
    }
}
