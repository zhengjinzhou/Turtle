package com.zhou.turtle.api;

import com.zhou.turtle.Constant;
import com.zhou.turtle.model.bean.UserBean;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by zhou on 2017/12/6.
 */

public interface XGGServer {
     String BASE_URL = Constant.URL;

    //登录
    @FormUrlEncoded
    @POST("login/login")
    Observable<UserBean> login(@Field("username") String username,@Field("password") String password);

    //注册
    @FormUrlEncoded
    @POST("login/register")
    Observable<UserBean> register(@Field("username") String username,@Field("password") String password);

}
