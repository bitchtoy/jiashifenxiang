package com.sequoia.vehicle.rental.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.jaeger.library.StatusBarUtil;
import com.sequoia.vehicle.rental.R;
import com.sequoia.vehicle.rental.activities.management.MortgageVehicleActivity;
import com.sequoia.vehicle.rental.activities.management.RentalVehicleActivity;
import com.sequoia.vehicle.rental.activities.profile.OwnersAuthActivity;
import com.sequoia.vehicle.rental.base.BaseActivity;
import com.sequoia.vehicle.rental.ui.banner.BannerCreator;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @author Administrator.
 * @date 2018/2/2.
 * @funtion 车主端
 */

public class OwnersActivity extends BaseActivity {
    @BindView(R.id.banner)
    ConvenientBanner<Integer> mBanner;
    @BindView(R.id.tv_auth)
    TextView mTvAuth;
    @BindView(R.id.tv_total_money)
    TextView mTvTotalMoney;
    @BindView(R.id.tv_car_num)
    TextView mTvCarNum;
    @BindView(R.id.tv_total_rent)
    TextView mTvTotalRent;
    @BindView(R.id.tv_mortgage)
    TextView mTvMortgage;
    @BindView(R.id.tv_rent)
    TextView mTvRent;
    @BindView(R.id.foot_image)
    ImageView mFootImage;
    @BindView(R.id.nested_scroll_view)
    NestedScrollView mNestedScrollView;
    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.tool_bar)
    Toolbar mToolBar;
    Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owners);
        ButterKnife.bind(this);
        initData();
    }

    public void initData() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(R.drawable.car_bg_banner);
        list.add(R.drawable.car_bg_banner);
        list.add(R.drawable.car_bg_banner);
        list.add(R.drawable.car_bg_banner);
        BannerCreator.setDefault(mBanner, list, null);
    }

    @SuppressWarnings("ConstantConditions")
    @OnClick({R.id.tv_auth, R.id.tv_mortgage, R.id.tv_rent, R.id.iv_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_auth:
               startActivity(new Intent(this, OwnersAuthActivity.class));
                break;
            case R.id.tv_mortgage:
                startActivity(new Intent(this, MortgageVehicleActivity.class));
                break;
            case R.id.tv_rent:
                startActivity(new Intent(this, RentalVehicleActivity.class));
                break;
            case R.id.iv_back:
                finish();
                break;
            default:
                break;
        }
    }
    @Override
    protected void setStatusBarColor() {
        StatusBarUtil.setTranslucentForImageView(this, 0, null);
    }
}
