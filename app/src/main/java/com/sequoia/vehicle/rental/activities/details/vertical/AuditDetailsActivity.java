package com.sequoia.vehicle.rental.activities.details.vertical;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;
import com.sequoia.vehicle.rental.R;
import com.sequoia.vehicle.rental.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Administrator.
 * @date 2018/2/2.
 * @funtion 审核车辆列表详情
 */

public class AuditDetailsActivity extends BaseActivity {


    @BindView(R.id.top_bar)
    QMUITopBar mTopBar;
    @BindView(R.id.btn_call_car)
    QMUIRoundButton mBtnCallCar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_audit);
        ButterKnife.bind(this);
        initTopBar();
    }

    private void initTopBar() {
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mTopBar.setTitle("车辆详情");
    }

    @OnClick(R.id.btn_call_car)
    public void onViewClicked() {
    }
}
