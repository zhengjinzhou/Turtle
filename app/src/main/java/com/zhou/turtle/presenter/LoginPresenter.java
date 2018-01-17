package com.zhou.turtle.presenter;

import android.content.Context;
import android.util.Log;

import com.zhou.turtle.bean.UserBean;
import com.zhou.turtle.model.LoginModel;
import com.zhou.turtle.model.impl.LoginImpl;
import com.zhou.turtle.ui.activity.iview.ILoginView;

/**
 * Created by zhou on 2018/1/17.
 * 注册桥梁
 */

public class LoginPresenter {
    private LoginImpl loginImpl;
    private ILoginView iLoginView;

    public LoginPresenter(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        this.loginImpl = new LoginImpl();
    }

    public void login() {
        iLoginView.showDialog();
        loginImpl.login(iLoginView.getUsername(), iLoginView.getPassword(), new LoginModel.OnLoginListener() {
            @Override
            public void loginSuccess(UserBean user) {
                iLoginView.hideDialog();
                Log.d("打印", "loginSuccess: " + user.toString());
                iLoginView.showLoginSuccess();
            }

            @Override
            public void loginFailed(String s) {
                iLoginView.hideDialog();
                iLoginView.showFailedError(s);
            }

            @Override
            public void loginComplete() {
                iLoginView.hideDialog();
            }
        });
    }

    public void showOrhide() {
        iLoginView.showOrhide();
    }
}
