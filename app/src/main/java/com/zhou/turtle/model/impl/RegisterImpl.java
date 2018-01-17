package com.zhou.turtle.model.impl;

import android.util.Log;

import com.zhou.turtle.api.APIServer;
import com.zhou.turtle.bean.UserBean;
import com.zhou.turtle.model.LoginModel;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by zhou on 2018/1/17.
 */

public class RegisterImpl implements LoginModel {

    //这里函数已经是注册方法了
    @Override
    public void login(String username, String passrword, final OnLoginListener loginListener) {
        APIServer.getInstence().getServer().register(username,passrword)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserBean>() {
                    @Override
                    public void onCompleted() {
                        loginListener.loginComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("", "onError: "+e.getMessage());
                    }

                    @Override
                    public void onNext(UserBean userBean) {
                        if (userBean.getError() == 0){
                            loginListener.loginSuccess(userBean);
                        }else {
                            loginListener.loginFailed(userBean.getMsg());
                        }
                    }
                });
    }
}
