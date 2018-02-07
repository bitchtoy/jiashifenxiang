package com.sequoia.vehicle.rental.activities.details.vertical;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;
import com.sequoia.vehicle.rental.R;
import com.sequoia.vehicle.rental.base.BaseActivity;
import com.sequoia.vehicle.rental.ui.dialog.CommonDialog;
import com.sequoia.vehicle.rental.ui.scroll.NestedScrollHandler;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Administrator.
 * @date 2018/2/2.
 * @funtion
 */

public class InvestmentDetailsActivity extends BaseActivity {

    @BindView(R.id.tool_bar)
    Toolbar mToolBar;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.nested_scroll_view)
    NestedScrollView mNestedScrollView;
    @BindView(R.id.btn_submit)
    Button mBtnSubmit;
    @BindView(R.id.iv_back)
    ImageView mIvBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_investors);
        ButterKnife.bind(this);
        NestedScrollHandler.create(mNestedScrollView, mToolBar, mTvTitle, ContextCompat.getColor(this, R.color.tool_bar_color));
    }

    @Override
    protected void setStatusBarColor() {
        StatusBarUtil.setTranslucentForImageView(this, 0, null);
    }

    @OnClick({R.id.btn_submit, R.id.iv_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_submit:
                new CommonDialog(this).setTitle("投资协议").setOnClickBottomListener(new CommonDialog.OnClickBottomListener() {
                    @Override
                    public void onPositiveClick() {

                    }

                    @Override
                    public void onNegativeClick() {

                    }
                }).show();
                break;
            case R.id.iv_back:
                finish();
                break;
            default:
                break;
        }
    }
}