package com.zhou.turtle.view;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.zhou.turtle.R;
import com.zhou.turtle.base.BaseActivity;
import com.zhou.turtle.model.bean.UserBean;
import com.zhou.turtle.presenter.LoginPresenter;
import com.zhou.turtle.util.ToastUtil;
import com.zhou.turtle.view.IView.ILogin;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements ILogin {

    private static final String TAG = "LoginActivity";
    @BindView(R.id.et_username)
    EditText et_username;
    @BindView(R.id.et_password)
    EditText et_password;
    private LoginPresenter presenter = new LoginPresenter(this);

    @Override
    public int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void init() {

    }

    @OnClick({R.id.bt_login})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_login:
                presenter.login();
                break;
        }
    }

    @Override
    public String getUserName() {
        if (TextUtils.isEmpty(et_username.getText().toString())) {
            ToastUtil.show(getApplicationContext(), "用户不能为空");
            return "";
        }
        return et_username.getText().toString();
    }

    @Override
    public String getPassword() {
        if (TextUtils.isEmpty(et_password.getText().toString())) {
            ToastUtil.show(getApplicationContext(), "密码不能为空");
            return "";
        }
        return et_password.getText().toString();
    }

    @Override
    public void toMainActivity(UserBean user) {
        if (user.getError() == 0) {
            startToActivity(MainActivity.class);
            finish();
        } else {
            ToastUtil.show(getApplicationContext(), "用户名或者密码错误");
        }
    }

    @Override
    public void showFailedError() {
        ToastUtil.show(getApplicationContext(), "失败");
    }

    @Override
    public void showLoading() {
        dialog.show();
    }

    @Override
    public void hideLoading() {
        dialog.dismiss();
    }

    @Override
    public void clearUserName() {

    }

    @Override
    public void showPassword() {

    }
}
