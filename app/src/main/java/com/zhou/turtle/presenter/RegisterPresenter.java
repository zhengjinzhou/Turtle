package com.zhou.turtle.presenter;

import android.util.Log;

import com.zhou.turtle.bean.UserBean;
import com.zhou.turtle.model.LoginModel;
import com.zhou.turtle.model.impl.RegisterImpl;
import com.zhou.turtle.ui.activity.iview.ILoginView;

/**
 * Created by zhou on 2018/1/17.
 */

public class RegisterPresenter {

    ILoginView iRegisterView;
    RegisterImpl register;

    public RegisterPresenter(ILoginView iRegisterView) {
        this.iRegisterView = iRegisterView;
        this.register = new RegisterImpl();
    }

    public void register(){
        iRegisterView.showDialog();
        register.login(iRegisterView.getUsername(), iRegisterView.getUsername(), new LoginModel.OnLoginListener() {
            @Override
            public void loginSuccess(UserBean user) {
                Log.d("打印", "loginSuccess: " + user.toString());
                iRegisterView.hideDialog();
                iRegisterView.showLoginSuccess();
            }

            @Override
            public void loginFailed(String s) {
                iRegisterView.hideDialog();
                iRegisterView.showFailedError(s);
            }

            @Override
            public void loginComplete() {
                iRegisterView.hideDialog();
            }
        });
    }

    public void showOrhide() {
        iRegisterView.showOrhide();
    }
}
