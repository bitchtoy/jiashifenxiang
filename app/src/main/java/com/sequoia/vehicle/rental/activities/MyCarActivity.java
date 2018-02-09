package com.sequoia.vehicle.rental.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.qmuiteam.qmui.widget.QMUITopBar;
import com.sequoia.vehicle.rental.R;
import com.sequoia.vehicle.rental.adapter.MyCarPagerAdapter;
import com.sequoia.vehicle.rental.base.BaseActivity;
import com.sequoia.vehicle.rental.fragment.MyCarFragment;
import com.sequoia.vehicle.rental.fragment.mycar.MyAuditFragment;
import com.sequoia.vehicle.rental.fragment.mycar.MyInvestorFragment;
import com.sequoia.vehicle.rental.fragment.mycar.MyLeaseFragment;
import com.sequoia.vehicle.rental.fragment.mycar.MyMortgageFragment;
import com.sequoia.vehicle.rental.fragment.mycar.MyRentalFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Administrator.
 * @date 2018/2/7.
 * @funtion
 */

public class MyCarActivity extends BaseActivity {
    @BindView(R.id.top_bar)
    QMUITopBar mTopBar;
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_car);
        ButterKnife.bind(this);
        initTopBar();
//        String[] title = {"抵押", "出租", "租赁", "投资", "审核"};
        String[] title = { "出租","抵押", "投资", "租赁", "审核"};
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(MyCarFragment.getInstance(0));
        fragments.add(MyCarFragment.getInstance(1));
        fragments.add(MyCarFragment.getInstance(2));
        fragments.add(MyCarFragment.getInstance(3));
        fragments.add(MyCarFragment.getInstance(4));
        mViewPager.setAdapter(new MyCarPagerAdapter(getSupportFragmentManager(), fragments, title));
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void initTopBar() {
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mTopBar.setTitle("我的车辆");
    }
}
