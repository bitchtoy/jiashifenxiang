package com.sequoia.vehicle.rental.activities.details.vertical;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;
import com.sequoia.vehicle.rental.R;
import com.sequoia.vehicle.rental.base.BaseActivity;
import com.sequoia.vehicle.rental.ui.scroll.NestedScrollHandler;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Administrator.
 * @date 2018/1/30.
 * @funtion 租赁
 */

public class LeaseDetailsActivity extends BaseActivity {
    @BindView(R.id.tool_bar)
    Toolbar mToolBar;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.nested_scroll_view)
    NestedScrollView mNestedScrollView;
    @BindView(R.id.btn_lease)
    Button mBtnLease;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_lease);
        ButterKnife.bind(this);
        NestedScrollHandler.create(mNestedScrollView, mToolBar, mTvTitle, ContextCompat.getColor(this, R.color.tool_bar_color));

    }

    @Override
    protected void setStatusBarColor() {
        StatusBarUtil.setTranslucentForImageView(this, 0, null);
    }

    @OnClick({R.id.btn_lease, R.id.iv_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_lease:
                startActivity(new Intent(LeaseDetailsActivity.this, LeaseSubmitActivity.class));
                break;
            case R.id.iv_back:
                finish();
                break;
            default:
                break;
        }
    }
}
