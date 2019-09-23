package com.cqian.app.bean;

import com.cqian.mvvm.base.BaseBean;

import java.util.List;

/**
 * Description:
 * Data: 2018/8/15
 *
 * @author: cqian
 */
public class LoginBean  extends BaseBean{

    public DataBean data;
    public static class DataBean {
        public boolean admin;
        public String email;
        public String icon;
        public int id;
        public String nickname;
        public String password;
        public String publicName;
        public String token;
        public int type;
        public String username;
        public List<?> chapterTops;
        public List<?> collectIds;
    }
}
