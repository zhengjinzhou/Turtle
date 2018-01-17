package com.zhou.turtle.base;

import android.app.Application;

import com.zhou.turtle.bean.UserBean;

/**
 * Created by zhou on 2018/1/17.
 */

public class App extends Application {

    private static App app;
    private UserBean userBean;

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public static App getInstance() {
        return app;
    }

    public static void setInstance(App app) {
        App.app = app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }
}
