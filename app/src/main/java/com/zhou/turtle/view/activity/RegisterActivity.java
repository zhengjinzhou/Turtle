package com.zhou.turtle.view.activity;

import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.zhou.turtle.R;
import com.zhou.turtle.base.BaseActivity;
import com.zhou.turtle.model.bean.UserBean;
import com.zhou.turtle.presenter.RegisterPrester;
import com.zhou.turtle.util.ToastUtil;
import com.zhou.turtle.view.activity.IView.IRegister;

import butterknife.BindView;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity implements IRegister {

    @BindView(R.id.et_username)
    EditText et_username;
    @BindView(R.id.et_password)
    EditText et_password;
    RegisterPrester prester = new RegisterPrester(this);

    @Override
    public int getLayout() {
        return R.layout.activity_register;
    }

    @Override
    public void init() {

    }

    @OnClick({R.id.bt_register, R.id.hint, R.id.clear, R.id.iv_back})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_register:
                prester.register();
                break;
            case R.id.hint:
                prester.showPassowrd();
                break;
            case R.id.clear:
                prester.clear();
                break;
            case R.id.iv_back:
                break;
        }
    }

    @Override
    public String getUserName() {
        if (TextUtils.isEmpty(et_username.getText().toString())) {
            ToastUtil.show(getApplicationContext(), "用户名不能为空");
            return "";
        }
        return et_username.getText().toString();
    }

    @Override
    public String getPassword() {
        if (TextUtils.isEmpty(et_username.getText().toString())) {
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

    }

    @Override
    public void showRegisterError() {
        ToastUtil.show(getApplicationContext(), "用户已存在");
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
        et_password.setText("");
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
