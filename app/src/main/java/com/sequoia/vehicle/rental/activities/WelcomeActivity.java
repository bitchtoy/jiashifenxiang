package com.sequoia.vehicle.rental.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.jaeger.library.StatusBarUtil;
import com.sequoia.vehicle.rental.R;
import com.sequoia.vehicle.rental.base.BaseActivity;
import com.sequoia.vehicle.rental.ui.banner.HolderCreator;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Administrator
 */
public class WelcomeActivity extends BaseActivity {


    @BindView(R.id.banner)
    ConvenientBanner<Integer> mBanner;
    @BindView(R.id.iv_dian_ji)
    ImageView mIvDianJi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
        final ArrayList<Integer> list = new ArrayList<>();
        list.add(R.mipmap.yindao1);
        list.add(R.mipmap.yindao2);
        list.add(R.mipmap.yindao3);
        mBanner.setPages(new HolderCreator(), list)
                .setPageIndicator(new int[]{R.drawable.dot_normal, R.drawable.dot_focus})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                    }

                    @Override
                    public void onPageSelected(int position) {
                        if (position == 2) {
                            mIvDianJi.setVisibility(View.VISIBLE);
                        } else {
                            mIvDianJi.setVisibility(View.GONE);
                        }
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {

                    }
                })
                .setCanLoop(false);
    }

    @Override
    protected void setStatusBarColor() {
        StatusBarUtil.setTranslucentForImageView(this, 0, null);
    }


    @OnClick(R.id.iv_dian_ji)
    public void onViewClicked() {
        startActivity(new Intent(WelcomeActivity.this, IndexActivity.class));
        finish();
    }
}
