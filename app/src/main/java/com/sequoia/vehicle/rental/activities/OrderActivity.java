package com.sequoia.vehicle.rental.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.qmuiteam.qmui.widget.QMUITopBar;
import com.sequoia.vehicle.rental.R;
import com.sequoia.vehicle.rental.adapter.OrderPagerAdapter;
import com.sequoia.vehicle.rental.base.BaseActivity;
import com.sequoia.vehicle.rental.fragment.order.AuditOrderFragment;
import com.sequoia.vehicle.rental.fragment.order.InvestmentOrderFragment;
import com.sequoia.vehicle.rental.fragment.order.LeaseOrderFragment;
import com.sequoia.vehicle.rental.fragment.order.MortgageOrderFragment;
import com.sequoia.vehicle.rental.fragment.order.RentOrderFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Administrator.
 * @date 2018/1/25.
 * 0.出租订单 发布的	待租赁	已租赁
 * 1.抵押订单 待投资	未审核	待确定	已抵押
 * 2.投资订单 待支付	已完成
 * 3.租赁订单 待支付	待确认	已完成
 * 4.审核订单 待审核	待确认	已完成
 */

public class OrderActivity extends BaseActivity {
    public static final String ORDER_TYPE = "ORDER_TYPE";
    public static final String INDEX_FRAGMENT = "INDEX_FRAGMENT";
    @BindView(R.id.top_bar)
    QMUITopBar mTopBar;
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    private ArrayList<String[]> mTitleList = null;
    private ArrayList<String> mTopBarTitle = null;

    private int mOrderType = -1;
    private int mIndexFragment = -1;
    private FragmentManager mManager = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        ButterKnife.bind(this);
        mOrderType = getIntent().getIntExtra(ORDER_TYPE, 0);
        mIndexFragment = getIntent().getIntExtra(INDEX_FRAGMENT, 0);
        mManager = getSupportFragmentManager();
        initData();
        initTopBar();

        initViewPager();
    }

    private void initViewPager() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        String[] title = mTitleList.get(mOrderType);
        for (int i = 0; i < title.length; i++) {

            switch (mOrderType) {
                case 0:
                    fragments.add(RentOrderFragment.getInstance(i));
                    break;
                case 1:
                    fragments.add(MortgageOrderFragment.getInstance(i));
                    break;
                case 2:
                    fragments.add(InvestmentOrderFragment.getInstance(i));
                    break;
                case 3:
                    fragments.add(LeaseOrderFragment.getInstance(i));
                    break;
                case 4:
                    fragments.add(AuditOrderFragment.getInstance(i));
                    break;
                default:
                    break;
            }

        }
        mViewPager.setAdapter(new OrderPagerAdapter(mManager, fragments, title));
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.setCurrentItem(mIndexFragment);
    }

    private void initTopBar() {
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mTopBar.setTitle(mTopBarTitle.get(mOrderType));
    }

    private void initData() {
        mTitleList = new ArrayList<>();
        mTopBarTitle = new ArrayList<>();
        String[] title0 = {"发布的", "待租赁", "已租赁"};
        String[] title1 = {"待投资", "未审核", "待确定", "已抵押"};
        String[] title2 = {"待支付", "已完成"};
        String[] title3 = {"待支付", "待确认", "已完成"};
        String[] title4 = {"待审核", "待确认", "已完成"};
        mTitleList.add(title0);
        mTitleList.add(title1);
        mTitleList.add(title2);
        mTitleList.add(title3);
        mTitleList.add(title4);
        mTopBarTitle.add("出租订单");
        mTopBarTitle.add("抵押订单");
        mTopBarTitle.add("投资订单");
        mTopBarTitle.add("租赁订单");
        mTopBarTitle.add("审核订单");
    }
}
