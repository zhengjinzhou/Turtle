package com.zhou.turtle.interceptor;

import com.zhou.turtle.Constant;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by zhou on 2017/12/6.
 */

public class BaseInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {

        Request original  = chain.request();

        HttpUrl url = original.url().newBuilder()
                .addQueryParameter("_token", Constant.TOKEN)
                .build();
        Request request = original.newBuilder()
                .method(original.method(),original.body())
                .url(url)
                .build();

        return chain.proceed(request);
    }
}
