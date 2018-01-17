package com.zhou.turtle.model;

import com.zhou.turtle.bean.UserBean;

/**
 * Created by zhou on 2018/1/17.
 *
 * 登录与注册一起共用
 */

public interface LoginModel {

    void login(String username,String passrword,OnLoginListener loginListener);

    interface OnLoginListener {

        void loginSuccess(UserBean user);

        void loginFailed(String s);

        void loginComplete();
    }
}
