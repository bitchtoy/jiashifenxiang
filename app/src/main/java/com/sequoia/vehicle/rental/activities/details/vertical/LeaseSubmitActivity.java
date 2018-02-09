package com.sequoia.vehicle.rental.activities.details.vertical;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.qmuiteam.qmui.widget.QMUITopBar;
import com.sequoia.vehicle.rental.R;
import com.sequoia.vehicle.rental.activities.CalendarActivity;
import com.sequoia.vehicle.rental.activities.OrderConfirmationActivity;
import com.sequoia.vehicle.rental.base.BaseActivity;
import com.sequoia.vehicle.rental.entities.multiple.FindCarBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Administrator.
 * @date 2018/1/31.
 * @funtion
 */

public class LeaseSubmitActivity extends BaseActivity {
    @BindView(R.id.top_bar)
    QMUITopBar mTopBar;
    @BindView(R.id.tv_start_time)
    TextView mTvStartTime;
    @BindView(R.id.tv_end_time)
    TextView mTvEndTime;
    @BindView(R.id.btn_submit)
    Button mBtnSubmit;
    @BindView(R.id.tv_lease_term)
    TextView mTvLeaseTerm;
    private FindCarBean mFindCarBean = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lease_submit);
        ButterKnife.bind(this);
        initTopBar();
        if (mFindCarBean == null) {
            mFindCarBean = new FindCarBean();
        }
    }

    private void initTopBar() {
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mTopBar.setTitle("租赁信息");
    }

    @OnClick({R.id.tv_start_time, R.id.tv_end_time, R.id.btn_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_start_time:
                Intent start = new Intent(this, CalendarActivity.class);
                start.putExtra("FIND_CAR_TIME", mFindCarBean);
                start.putExtra("START_END", 0);
                startActivityForResult(start, 1000);
                break;
            case R.id.tv_end_time:
                Intent end = new Intent(this, CalendarActivity.class);
                end.putExtra("START_END", 1);
                end.putExtra("FIND_CAR_TIME", mFindCarBean);
                startActivityForResult(end, 1000);
                break;
            case R.id.btn_submit:
                startActivity(new Intent(this, OrderConfirmationActivity.class));
                break;
            default:
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1000 && resultCode == 1000) {
            mFindCarBean = (FindCarBean) data.getSerializableExtra("FIND_CAR_TIME");
            if (mFindCarBean.startTime != null) {
                mTvStartTime.setText(mFindCarBean.startTime);
            }
            if (mFindCarBean.endTime != null) {
                mTvEndTime.setText(mFindCarBean.endTime);
            }

            if (mFindCarBean.getDays() > 0) {
                mTvLeaseTerm.setText(String.format("%d天", mFindCarBean.getDays()));
            }

        }
    }

}
