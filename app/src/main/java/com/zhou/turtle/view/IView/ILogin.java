package com.zhou.turtle.view.IView;

import com.zhou.turtle.model.bean.UserBean;

/**
 * Created by zhou on 2017/12/6.
 */

public interface ILogin {
    String getUserName();

    String getPassword();

    void toMainActivity(UserBean user);

    void showFailedError();

    void showLoading();

    void hideLoading();

    void clearUserName();

    void showPassword();
}
