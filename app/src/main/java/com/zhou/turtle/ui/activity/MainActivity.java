package com.zhou.turtle.ui.activity;

import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.CheckableImageButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.zhou.turtle.R;
import com.zhou.turtle.base.BaseActivity;
import com.zhou.turtle.util.ToastUtil;
import com.zhou.turtle.ui.fragment.ChinaFragment;
import com.zhou.turtle.ui.fragment.FriendFragment;
import com.zhou.turtle.ui.fragment.HelpFragment;
import com.zhou.turtle.ui.fragment.HomeFragment;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    private HomeFragment homeFragment;
    private FriendFragment friendFragment;
    private HelpFragment helpFragment;
    private ChinaFragment chinaFragment;
    private Fragment[] fragments;
    private int currentTabIndex = 0;

    @BindView(R.id.tv_fragment_home) CheckableImageButton tv_fragment_home;
    @BindView(R.id.tv_fragment_friend) CheckableImageButton tv_fragment_friend;
    @BindView(R.id.iv_fragment_add) ImageView iv_fragment_add;
    @BindView(R.id.tv_fragment_china) CheckableImageButton tv_fragment_china;
    @BindView(R.id.tv_fragment_help) CheckableImageButton tv_fragment_help;
    @BindView(R.id.fragment_content) FrameLayout fragment_content;

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {
        if (Build.VERSION.SDK_INT >= 21){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    |View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        initFragment();
    }

    private void initFragment() {
        homeFragment = new HomeFragment();
        friendFragment = new FriendFragment();
        helpFragment = new HelpFragment();
        chinaFragment = new ChinaFragment();

        fragments = new Fragment[]{homeFragment, friendFragment, helpFragment, chinaFragment};
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_content, homeFragment)
                .hide(homeFragment)
                .add(R.id.fragment_content, friendFragment)
                .hide(friendFragment)
                .add(R.id.fragment_content, chinaFragment)
                .hide(chinaFragment)
                .add(R.id.fragment_content, helpFragment)
                .hide(helpFragment)
                .show(homeFragment)
                .commit();
        setCheckImager(0);
    }

    @OnClick({R.id.tv_fragment_home, R.id.tv_fragment_friend, R.id.iv_fragment_add, R.id.tv_fragment_china, R.id.tv_fragment_help})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.tv_fragment_home:
                showTabFragment(0);
                break;
            case R.id.tv_fragment_friend:
                showTabFragment(1);
                break;
            case R.id.tv_fragment_china:
                showTabFragment(2);
                break;
            case R.id.tv_fragment_help:
                showTabFragment(3);
                break;
            case R.id.iv_fragment_add:
                ToastUtil.show(getApplicationContext(),"待续");
                break;
        }
    }

    /**
     * 选择显示fragment
     *
     * @param pos
     */
    private void showTabFragment(int pos) {
        FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
        trx.hide(fragments[currentTabIndex]);
        setUnCheckImager(currentTabIndex);
        if (!fragments[pos].isAdded()) {
            trx.add(R.id.fragment_content, fragments[pos]);
        }
        setCheckImager(pos);
        trx.show(fragments[pos]);
        trx.commit();
        currentTabIndex = pos;
    }

    private void setCheckImager(int pos) {
        switch (pos) {
            case 0:
                tv_fragment_home.setImageResource(R.drawable.home_sel);
                break;
            case 1:
                tv_fragment_friend.setImageResource(R.drawable.chat_sel);
                break;
            case 2:
                tv_fragment_china.setImageResource(R.drawable.china_sel);
                break;
            case 3:
                tv_fragment_help.setImageResource(R.drawable.help_sel);
                break;
        }
    }

    private void setUnCheckImager(int pos) {
        switch (pos) {
            case 0:
                tv_fragment_home.setImageResource(R.drawable.home_bg);
                break;
            case 1:
                tv_fragment_friend.setImageResource(R.drawable.chat_bg);
                break;
            case 2:
                tv_fragment_china.setImageResource(R.drawable.china_bg);
                break;
            case 3:
                tv_fragment_help.setImageResource(R.drawable.help_bg);
                break;
        }
    }
}
