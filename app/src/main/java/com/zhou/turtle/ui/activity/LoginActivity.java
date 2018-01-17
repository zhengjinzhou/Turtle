package com.zhou.turtle.ui.activity;

import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import com.zhou.turtle.R;
import com.zhou.turtle.base.BaseActivity;
import com.zhou.turtle.presenter.LoginPresenter;
import com.zhou.turtle.ui.activity.iview.ILoginView;
import com.zhou.turtle.util.ToastUtil;
import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements ILoginView {

    private static final String TAG = "LoginActivity";
    private LoginPresenter mLoginPresenter = new LoginPresenter(this);
    @BindView(R.id.et_username) EditText et_username;
    @BindView(R.id.et_password) EditText et_password;

    @Override
    public int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void init() {
        et_username.setText("3535@qq.com");
        et_password.setText("123456");
    }

    @OnClick({R.id.bt_login, R.id.clear, R.id.hint, R.id.iv_back})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.bt_login:
                if (TextUtils.isEmpty(et_username.getText().toString().trim())) {
                    ToastUtil.show(getApplicationContext(), "用户名不能为空");
                    return;
                }
                if (TextUtils.isEmpty(et_password.getText().toString().trim())) {
                    ToastUtil.show(getApplicationContext(), "密码不能为空");
                    return;
                }
                if (et_password.getText().toString().trim().length() < 6) {
                    ToastUtil.show(getApplicationContext(), "密码不能少于6位");
                    return;
                }
                mLoginPresenter.login();
                break;
            case R.id.clear:
                et_username.setText("");
                break;
            case R.id.hint:
                mLoginPresenter.showOrhide();
                break;
        }
    }

    @Override
    public String getUsername() {
        return et_username.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return et_password.getText().toString().trim();
    }


    @Override
    public void showOrhide() {
        if (et_password.getInputType() == 129) {
            et_password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        } else {
            et_password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }
        et_password.setSelection(et_password.getText().toString().length());
    }

    @Override
    public void showDialog() {
        dialog.show();
    }

    @Override
    public void hideDialog() {
        dialog.dismiss();
    }

    @Override
    public void showFailedError(String s) {
        ToastUtil.show(getApplicationContext(), s);
    }

    @Override
    public void showLoginSuccess() {
        startToActivity(MainActivity.class);
        finish();
    }
}

