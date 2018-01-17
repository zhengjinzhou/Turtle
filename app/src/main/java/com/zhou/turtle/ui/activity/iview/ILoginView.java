package com.zhou.turtle.ui.activity.iview;

/**
 * Created by zhou on 2018/1/17.
 *
 * 登录与注册的方法
 */

public interface ILoginView {

    String getUsername();

    String getPassword();

    void showOrhide();

    void showDialog();

    void hideDialog();

    void showFailedError(String s);

    void showLoginSuccess();
}
