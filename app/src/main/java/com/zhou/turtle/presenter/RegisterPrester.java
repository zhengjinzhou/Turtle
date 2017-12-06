package com.zhou.turtle.presenter;

import android.text.TextUtils;

import com.zhou.turtle.api.APIServer;
import com.zhou.turtle.model.bean.UserBean;
import com.zhou.turtle.view.activity.IView.IRegister;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by zhou on 2017/12/6.
 */

public class RegisterPrester {

    IRegister register;
    APIServer server;

    public RegisterPrester(IRegister register){
        this.register = register;
        server = new APIServer();
    }

    public void register(){
        if (!TextUtils.isEmpty(register.getUserName()) &&!TextUtils.isEmpty(register.getPassword())){
            register.showLoading();
            server.getServer().register(register.getUserName(),register.getPassword())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Observer<UserBean>() {
                @Override
                public void onCompleted() {
                    register.hideLoading();
                }

                @Override
                public void onError(Throwable e) {
                    register.hideLoading();
                    register.showFailedError();
                }

                @Override
                public void onNext(UserBean userBean) {
                    register.hideLoading();
                    if (userBean.getError()==0){
                        register.toMainActivity(userBean);
                    }else {
                        register.showRegisterError();
                    }
                }
            });
        }
    }
    public void clear(){
        register.clearUserName();
    }

    public void showPassowrd(){
        register.showPassword();
    }
}
