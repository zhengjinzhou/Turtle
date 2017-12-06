package com.zhou.turtle.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zhou.turtle.R;
import com.zhou.turtle.widget.LoadDialog;

import butterknife.ButterKnife;

/**
 * Created by zhou on 2017/12/5.
 */

public abstract class BaseActivity extends AppCompatActivity {

    public abstract int getLayout();
    public abstract void init();
    protected LoadDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        dialog = new LoadDialog(this,false,getString(R.string.logding));
        init();
    }

    public void startToActivity(Class<?> lazz){
        Intent intent = new Intent(this,lazz);
        startActivity(intent);
    }
}
