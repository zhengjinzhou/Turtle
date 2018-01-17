package com.zhou.turtle.ui.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zhou.turtle.R;
import com.zhou.turtle.base.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by zhou on 2017/12/6.
 */

public class HomeFragment extends BaseFragment {

    @BindView(R.id.recycleView)
    RecyclerView recyclerView;

    @Override
    public int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void init(View v) {

    }

    @OnClick({R.id.iv_message, R.id.iv_setting, R.id.ll_posts, R.id.ll_followes, R.id.ll_following,
            R.id.ll_application, R.id.ll_little_turtles, R.id.ll_photos, R.id.ll_video, R.id.ll_case,
            R.id.ll_interactive, R.id.ll_video_call, R.id.ll_task})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_little_turtles:

                break;

            case R.id.ll_photos:

                break;

            case R.id.ll_video:

                break;

            case R.id.ll_case:

                break;

            case R.id.ll_interactive:

                break;

            case R.id.ll_video_call:

                break;

            case R.id.ll_task:

                break;
            case R.id.ll_application:

                break;

            case R.id.ll_following:

                break;

            case R.id.ll_followes:

                break;
            case R.id.ll_posts:

                break;

            case R.id.iv_message:

                break;

            case R.id.iv_setting:

                break;
        }
    }
}
