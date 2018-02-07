package com.sequoia.vehicle.rental.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.qmuiteam.qmui.widget.QMUITopBar;
import com.sequoia.vehicle.rental.R;
import com.sequoia.vehicle.rental.adapter.AuditorAdapter;
import com.sequoia.vehicle.rental.adapter.order.AuditOrderAdapter;
import com.sequoia.vehicle.rental.base.BaseActivity;
import com.sequoia.vehicle.rental.ui.recycler.BaseDecoration;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Administrator.
 * @date 2018/2/7.
 * @funtion 选择审核员列表
 */

public class AuditorVerticalActivity extends BaseActivity {
    @BindView(R.id.top_bar)
    QMUITopBar mTopBar;
    @BindView(R.id.recycler_View)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auditor_vertical);
        ButterKnife.bind(this);
        initTopBar();
        initRecyclerView();
    }

    private void initRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(BaseDecoration.create(0, 0, ContextCompat.getColor(this, R.color.color_F4F8F9), 2));
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        AuditorAdapter auditOrderAdapter = new AuditorAdapter(R.layout.adapter_auditor_item, list);
        mRecyclerView.setAdapter(auditOrderAdapter);
    }

    private void initTopBar() {
        mTopBar.setTitle("审核员列表");
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
