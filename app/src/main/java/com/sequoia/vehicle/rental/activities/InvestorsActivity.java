package com.sequoia.vehicle.rental.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jaeger.library.StatusBarUtil;
import com.sequoia.vehicle.rental.R;
import com.sequoia.vehicle.rental.activities.details.vertical.InvestmentDetailsActivity;
import com.sequoia.vehicle.rental.adapter.InvestorMultipleAdapter;
import com.sequoia.vehicle.rental.base.BaseActivity;
import com.sequoia.vehicle.rental.base.MultipleItemBean;
import com.sequoia.vehicle.rental.entities.multiple.DataConverter;
import com.sequoia.vehicle.rental.ui.recycler.BaseDecoration;
import com.sequoia.vehicle.rental.ui.recycler.ItemStyle;
import com.sequoia.vehicle.rental.ui.recycler.RecyclerHandler;
import com.sequoia.vehicle.rental.ui.recycler.RecyclerViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Administrator.
 * @date 2018/2/2.
 * @funtion 投资端
 */

public class InvestorsActivity extends BaseActivity {
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout mRefreshLayout;
    @BindView(R.id.iv_back)
    AppCompatImageView mIvBack;
    @BindView(R.id.tv_search)
    AppCompatTextView mTvSearch;
    @BindView(R.id.iv_filter)
    AppCompatImageView mIvFilter;
    @BindView(R.id.tool_bar)
    Toolbar mToolBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investors);
        ButterKnife.bind(this);
        RecyclerHandler.create(mRecyclerView, mToolBar, null, ContextCompat.getColor(this, R.color.tool_bar_color));
        initRecyclerView();
    }

    private void initRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(BaseDecoration.create(0, 0, ContextCompat.getColor(this, R.color.color_F4F8F9), 2));
        InvestorMultipleAdapter adapter = new InvestorMultipleAdapter(DataConverter.getInvestorData());
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                MultipleItemBean bean = (MultipleItemBean) adapter.getData().get(position);
                if (bean.getItemType() == ItemStyle.MULTIPLE_INVESTOR) {
                    startActivity(new Intent(InvestorsActivity.this, InvestmentDetailsActivity.class));
                }
            }
        });
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    protected void setStatusBarColor() {
        StatusBarUtil.setTranslucentForImageView(this, 0, null);
    }

    @OnClick({R.id.iv_back, R.id.tv_search, R.id.iv_filter})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_search:
                break;
            case R.id.iv_filter:
                break;
            default:
                break;
        }
    }
}
