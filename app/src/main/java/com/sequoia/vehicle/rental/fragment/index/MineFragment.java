package com.sequoia.vehicle.rental.fragment.index;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.sequoia.vehicle.rental.R;
import com.sequoia.vehicle.rental.activities.MyCarActivity;
import com.sequoia.vehicle.rental.activities.OrderActivity;
import com.sequoia.vehicle.rental.activities.profile.IntegralActivity;
import com.sequoia.vehicle.rental.activities.profile.SettingActivity;
import com.sequoia.vehicle.rental.activities.profile.UserAuthActivity;
import com.sequoia.vehicle.rental.activities.profile.WalletActivity;
import com.sequoia.vehicle.rental.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @author Administrator.
 * @date 2018/2/1.
 * @funtion 我的
 */

public class MineFragment extends BaseFragment {
    @BindView(R.id.tv_setting)
    ImageView mTvSetting;
    @BindView(R.id.tool_bar)
    Toolbar mToolBar;
    @BindView(R.id.tv_name)
    TextView mTvName;
    @BindView(R.id.iv_avatar)
    QMUIRadiusImageView mIvAvatar;
    @BindView(R.id.tv_account_balance)
    TextView mTvAccountBalance;
    @BindView(R.id.account_balance_layout)
    LinearLayout mAccountBalanceLayout;
    @BindView(R.id.tv_integral)
    TextView mTvIntegral;
    @BindView(R.id.integral_layout)
    LinearLayout mIntegralLayout;
    @BindView(R.id.tv_all_order)
    TextView mTvAllOrder;
    @BindView(R.id.tv_posted)
    TextView mTvPosted;
    @BindView(R.id.tv_rented)
    TextView mTvRented;
    @BindView(R.id.tv_leased)
    TextView mTvLeased;
    @BindView(R.id.tv_mortgage_orders)
    TextView mTvMortgageOrders;
    @BindView(R.id.tv_investment_orders)
    TextView mTvInvestmentOrders;
    @BindView(R.id.tv_lease_orders)
    TextView mTvLeaseOrders;
    @BindView(R.id.tv_audit_orders)
    TextView mTvAuditOrders;
    @BindView(R.id.tv_my_car)
    TextView mTvMyCar;
    @BindView(R.id.tv_my_auth)
    TextView mTvMyAuth;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    public void initData() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    //设置
    @OnClick({R.id.tv_setting
            //账户余额 积分
            , R.id.account_balance_layout, R.id.integral_layout
            //所有订单
            , R.id.tv_all_order
            //发布的 待租赁 已租赁
            , R.id.tv_posted, R.id.tv_rented, R.id.tv_leased
            //抵押 投资 租赁
            , R.id.tv_mortgage_orders, R.id.tv_investment_orders, R.id.tv_lease_orders
            //审核 我的车辆 我的消息
            , R.id.tv_audit_orders, R.id.tv_my_car, R.id.tv_my_auth})
    public void onViewClicked(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.tv_setting:
                intent = new Intent(mActivity, SettingActivity.class);
                break;
            case R.id.account_balance_layout:
//                if (isNumber(mTvAccountBalance.getText().toString().trim(), false)) {
//                    final double integral = Double.parseDouble(mTvIntegral.getText().toString().trim());
                intent = new Intent(mActivity, WalletActivity.class);
//                intent.putExtra(IntegralActivity.INTEGRAL, balance);
//                }
                break;
            case R.id.integral_layout:
//                if (isNumber(mTvIntegral.getText().toString().trim(), true)) {
//                    final int integral = Integer.parseInt(mTvIntegral.getText().toString().trim());
                intent = new Intent(mActivity, IntegralActivity.class);
//                    intent.putExtra(IntegralActivity.INTEGRAL, integral);
//                }
                break;
            case R.id.tv_all_order:
                intent = new Intent(mActivity, OrderActivity.class);
                intent.putExtra(OrderActivity.ORDER_TYPE, 0);
                break;
            case R.id.tv_posted:
                intent = new Intent(mActivity, OrderActivity.class);
                intent.putExtra(OrderActivity.ORDER_TYPE, 0);
                intent.putExtra(OrderActivity.INDEX_FRAGMENT, 0);
                break;
            case R.id.tv_rented:
                intent = new Intent(mActivity, OrderActivity.class);
                intent.putExtra(OrderActivity.ORDER_TYPE, 0);
                intent.putExtra(OrderActivity.INDEX_FRAGMENT, 1);
                break;
            case R.id.tv_leased:
                intent = new Intent(mActivity, OrderActivity.class);
                intent.putExtra(OrderActivity.ORDER_TYPE, 0);
                intent.putExtra(OrderActivity.INDEX_FRAGMENT, 2);
                break;
            case R.id.tv_mortgage_orders:
                intent = new Intent(mActivity, OrderActivity.class);
                intent.putExtra(OrderActivity.ORDER_TYPE, 1);
                break;
            case R.id.tv_investment_orders:
                intent = new Intent(mActivity, OrderActivity.class);
                intent.putExtra(OrderActivity.ORDER_TYPE, 2);
                break;
            case R.id.tv_lease_orders:
                intent = new Intent(mActivity, OrderActivity.class);
                intent.putExtra(OrderActivity.ORDER_TYPE, 3);
                break;
            case R.id.tv_audit_orders:
                intent = new Intent(mActivity, OrderActivity.class);
                intent.putExtra(OrderActivity.ORDER_TYPE, 4);
                break;
            case R.id.tv_my_car:
                intent = new Intent(mActivity, MyCarActivity.class);
                break;
            case R.id.tv_my_auth:
                intent = new Intent(mActivity, UserAuthActivity.class);
                break;

            default:
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}
