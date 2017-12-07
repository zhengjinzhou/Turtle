package com.zhou.turtle.view.activity;

import android.support.design.widget.AppBarLayout;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.zhou.turtle.R;
import com.zhou.turtle.base.BaseActivity;
import com.zhou.turtle.model.bean.UserBean;
import com.zhou.turtle.presenter.LoginPresenter;
import com.zhou.turtle.util.ToastUtil;
import com.zhou.turtle.view.activity.IView.ILogin;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements ILogin {

    private static final String TAG = "LoginActivity";
    @BindView(R.id.et_username) EditText et_username;
    @BindView(R.id.et_password) EditText et_password;

    private LoginPresenter presenter = new LoginPresenter(this);

    @Override
    public int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void init() {
        et_username.setText("3232@qq.com");
        et_password.setText("123456");
    }

    @OnClick({R.id.bt_login, R.id.clear, R.id.hint})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_login:
                presenter.login();
                break;
            case R.id.clear:
                presenter.clear();
                break;
            case R.id.hint:
                presenter.showPassword();
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
        startToActivity(MainActivity.class);
        finish();
    }

    @Override
    public void showFailedError() {
        ToastUtil.show(getApplicationContext(), "失败");
    }

    @Override
    public void showLoginError() {
        ToastUtil.show(getApplicationContext(), "用户名或者密码错误");
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
        et_username.setText("");
    }

    @Override
    public void showPassword() {
        int type = InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD;
        if (et_password.getInputType() == type) {
            et_password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            et_password.setSelection(et_password.getText().length());     //把光标设置到当前文本末尾
        } else {
            et_password.setInputType(type);
            et_password.setSelection(et_password.getText().length());
        }
    }
}
