package com.sequoia.vehicle.rental.fragment.index;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;
import com.sequoia.vehicle.rental.R;
import com.sequoia.vehicle.rental.activities.details.vertical.AuditDetailsActivity;
import com.sequoia.vehicle.rental.activities.profile.AuditorAutoActivity;
import com.sequoia.vehicle.rental.adapter.AuditMultipleAdapter;
import com.sequoia.vehicle.rental.base.BaseFragment;
import com.sequoia.vehicle.rental.entities.multiple.DataConverter;
import com.sequoia.vehicle.rental.ui.recycler.BaseDecoration;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @author Administrator.
 * @date 2018/2/1.
 * @funtion 审核
 */

public class AuditFragment extends BaseFragment implements BaseQuickAdapter.OnItemClickListener {
    @BindView(R.id.recycler_View)
    RecyclerView mRecyclerView;
    @BindView(R.id.bnt_become_auditor)
    QMUIRoundButton mBntBecomeAuditor;
    @BindView(R.id.poster_layout)
    RelativeLayout mPosterLayout;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_audit, container, false);
        unbinder = ButterKnife.bind(this, view);
        initRecyclerView();
        return view;
    }

    private void initRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mRecyclerView.addItemDecoration(BaseDecoration.create(0, 0, ContextCompat.getColor(mActivity, R.color.color_F4F8F9), 3));
        AuditMultipleAdapter adapter = new AuditMultipleAdapter(DataConverter.getAuditData());
        mRecyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.bnt_become_auditor)
    public void onViewClicked() {
        if (mPosterLayout.getVisibility() == View.VISIBLE) {
            startActivity(new Intent(mActivity, AuditorAutoActivity.class));
            mPosterLayout.setVisibility(View.GONE);
        }
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        startActivity(new Intent(mActivity, AuditDetailsActivity.class));
    }
}
