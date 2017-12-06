package com.zhou.turtle.view.activity;

import android.view.View;

import com.zhou.turtle.R;
import com.zhou.turtle.base.BaseActivity;
import com.zhou.turtle.util.ToastUtil;

import butterknife.OnClick;

public class StartActivity extends BaseActivity {

    @Override
    public int getLayout() {
        return R.layout.activity_start;
    }

    @Override
    public void init() {

    }

    @OnClick({R.id.tv_login, R.id.tv_signin, R.id.tv_facebook, R.id.tv_twitter})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_login:
                startToActivity(LoginActivity.class);
                break;
            case R.id.tv_signin:
                startToActivity(RegisterActivity.class);
                break;
            case R.id.tv_facebook:
                ToastUtil.show(this, "待续");
                break;
            case R.id.tv_twitter:
                ToastUtil.show(this, "待续");
                break;
        }
    }
}
