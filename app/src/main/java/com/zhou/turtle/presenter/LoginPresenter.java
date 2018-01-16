package com.zhou.turtle.presenter;

import android.text.TextUtils;

import com.zhou.turtle.api.APIServer;
import com.zhou.turtle.bean.UserBean;
import com.zhou.turtle.view.activity.IView.ILogin;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by zhou on 2017/12/6.
 */

public class LoginPresenter {
    ILogin login;
    APIServer server;

    public LoginPresenter(ILogin login) {
        this.login = login;
        this.server = new APIServer();
    }

    public void login() {
        if (!TextUtils.isEmpty(login.getUserName()) && !TextUtils.isEmpty(login.getPassword())) {
            login.showLoading();
            server.getServer().login(login.getUserName(), login.getPassword())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<UserBean>() {
                        @Override
                        public void onCompleted() {
                            login.hideLoading();
                        }

                        @Override
                        public void onError(Throwable e) {
                            login.hideLoading();
                            login.showFailedError();
                        }

                        @Override
                        public void onNext(UserBean userBean) {
                            if (userBean.getError() == 0){
                                login.hideLoading();
                                login.toMainActivity(userBean);
                                //保存到app中
                            }else{
                                login.hideLoading();
                                login.showLoginError();
                            }
                        }
                    });
        }
    }

    public void clear(){
        login.clearUserName();
    }

    public void showPassword(){
        login.showPassword();
    }

}
