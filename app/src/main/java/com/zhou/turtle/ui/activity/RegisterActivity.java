package com.zhou.turtle.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.zhou.turtle.R;
import com.zhou.turtle.base.BaseActivity;
import com.zhou.turtle.presenter.LoginPresenter;
import com.zhou.turtle.presenter.RegisterPresenter;
import com.zhou.turtle.ui.activity.iview.ILoginView;
import com.zhou.turtle.util.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity implements ILoginView{

    @BindView(R.id.et_username) EditText et_username;
    @BindView(R.id.et_password) EditText et_password;
    private RegisterPresenter mRegisterPresenter = new RegisterPresenter(this);

    @Override
    public int getLayout() {
        return R.layout.activity_register;
    }

    @Override
    public void init() {

    }

    @OnClick({R.id.bt_register,R.id.iv_back,R.id.clear,R.id.hint}) void onClick(View view){
        switch (view.getId()){
            case R.id.bt_register:
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
                mRegisterPresenter.register();
                break;
            case R.id.iv_back:
                finish();
                break;
            case R.id.hint:
                mRegisterPresenter.showOrhide();
                break;
            case R.id.clear:
                et_username.setText("");
                break;
        }
    }
    @Override
    public String getUsername() {
        return et_username.getText().toString();
    }

    @Override
    public String getPassword() {
        return et_password.getText().toString();
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
        startToActivity(LoginActivity.class);
        finish();
    }
}
