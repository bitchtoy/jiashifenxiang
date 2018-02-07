package com.sequoia.vehicle.rental.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.widget.FrameLayout;

import com.jaeger.library.StatusBarUtil;
import com.qmuiteam.qmui.widget.QMUITabSegment;
import com.sequoia.vehicle.rental.R;
import com.sequoia.vehicle.rental.base.BaseActivity;
import com.sequoia.vehicle.rental.base.BaseFragment;
import com.sequoia.vehicle.rental.fragment.index.AuditFragment;
import com.sequoia.vehicle.rental.fragment.index.HomeFragment;
import com.sequoia.vehicle.rental.fragment.index.MineFragment;
import com.sequoia.vehicle.rental.fragment.index.MsgFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Administrator.
 * @date 2018/2/1.
 * @funtion
 */

public class IndexActivity extends BaseActivity {

    @BindView(R.id.container_layout)
    FrameLayout mContainerLayout;
    @BindView(R.id.bottom_tabs)
    QMUITabSegment mBottomTabs;

    private FragmentManager fm = null;
    private HomeFragment mHomeFragment = null;
    private AuditFragment mAuditFragment = null;
    private MsgFragment mMsgFragment = null;
    private MineFragment mMineFragment = null;

    private int mPrPosition = -1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        ButterKnife.bind(this);
        fm = getSupportFragmentManager();
        initBottomTab();
        mBottomTabs.selectTab(0);
    }

    /**
     * 初始化tab相关
     */
    private void initBottomTab() {
        mBottomTabs.setDefaultNormalColor(ContextCompat.getColor(this, R.color.color_A0A0A0));
        mBottomTabs.setDefaultSelectedColor(ContextCompat.getColor(this, R.color.color_FF5C60));
        QMUITabSegment.Tab home = new QMUITabSegment.Tab(
                ContextCompat.getDrawable(this, R.mipmap.car_icon_home_n),
                ContextCompat.getDrawable(this, R.mipmap.car_icon_home_s),
                getResources().getString(R.string.index_home), false
        );
        QMUITabSegment.Tab audit = new QMUITabSegment.Tab(
                ContextCompat.getDrawable(this, R.mipmap.home_audit_n),
                ContextCompat.getDrawable(this, R.mipmap.home_audit_s),
                getResources().getString(R.string.index_audit), false
        );
        QMUITabSegment.Tab msg = new QMUITabSegment.Tab(
                ContextCompat.getDrawable(this, R.mipmap.home_message_n),
                ContextCompat.getDrawable(this, R.mipmap.home_message_s),
                getResources().getString(R.string.index_message), false
        );
        QMUITabSegment.Tab mine = new QMUITabSegment.Tab(
                ContextCompat.getDrawable(this, R.mipmap.car_icon_my_n),
                ContextCompat.getDrawable(this, R.mipmap.car_icon_my_s),
                getResources().getString(R.string.index_mine), false
        );
        mBottomTabs.addTab(home).addTab(audit).addTab(msg).addTab(mine);

        mBottomTabs.addOnTabSelectedListener(new QMUITabSegment.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int index) {
                if (mPrPosition != index) {
                    showFragment(index);
                    mPrPosition = index;
                }

            }

            @Override
            public void onTabUnselected(int index) {

            }

            @Override
            public void onTabReselected(int index) {

            }

            @Override
            public void onDoubleTap(int index) {

            }
        });
    }

    @Override
    protected void setStatusBarColor() {
        StatusBarUtil.setTranslucentForImageView(this, 0, null);
    }

    private void showFragment(int position) {
        FragmentTransaction transaction = fm.beginTransaction();
        switch (position) {
            case 0:
                if (mHomeFragment == null) {
                    mHomeFragment = new HomeFragment();
                    transaction.add(R.id.container_layout, mHomeFragment);
                } else {
                    transaction.show(mHomeFragment);
                }
                hideFragment(mAuditFragment, transaction);
                hideFragment(mMsgFragment, transaction);
                hideFragment(mMineFragment, transaction);
                break;
            case 1:
                if (mAuditFragment == null) {
                    mAuditFragment = new AuditFragment();
                    transaction.add(R.id.container_layout, mAuditFragment);
                } else {
                    transaction.show(mAuditFragment);
                }
                hideFragment(mHomeFragment, transaction);
                hideFragment(mMsgFragment, transaction);
                hideFragment(mMineFragment, transaction);
                break;
            case 2:
                if (mMsgFragment == null) {
                    mMsgFragment = new MsgFragment();
                    transaction.add(R.id.container_layout, mMsgFragment);
                } else {
                    transaction.show(mMsgFragment);
                }
                hideFragment(mHomeFragment, transaction);
                hideFragment(mAuditFragment, transaction);
                hideFragment(mMineFragment, transaction);
                break;
            case 3:
                if (mMineFragment == null) {
                    mMineFragment = new MineFragment();
                    transaction.add(R.id.container_layout, mMineFragment);
                } else {
                    transaction.show(mMineFragment);
                }
                hideFragment(mHomeFragment, transaction);
                hideFragment(mAuditFragment, transaction);
                hideFragment(mMsgFragment, transaction);
                break;
            default:
                break;
        }
        transaction.commit();

    }

    private void hideFragment(BaseFragment fragment, FragmentTransaction transaction) {
        if (fragment != null) {
            transaction.hide(fragment);
        }
    }
}
