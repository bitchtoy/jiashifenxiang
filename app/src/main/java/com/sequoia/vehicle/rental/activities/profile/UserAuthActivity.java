package com.sequoia.vehicle.rental.activities.profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qmuiteam.qmui.widget.QMUITopBar;
import com.sequoia.vehicle.rental.R;
import com.sequoia.vehicle.rental.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Administrator.
 * @date 2018/1/30.
 * @funtion
 */

public class UserAuthActivity extends BaseActivity {
    @BindView(R.id.top_bar)
    QMUITopBar mTopBar;
    @BindView(R.id.tv_id_card)
    TextView mTvIdCard;
    @BindView(R.id.id_card_layout)
    LinearLayout mIdCardLayout;
    @BindView(R.id.tv_drive)
    TextView mTvDrive;
    @BindView(R.id.drive_layout)
    LinearLayout mDriveLayout;
    @BindView(R.id.tv_driving)
    TextView mTvDriving;
    @BindView(R.id.driving_layout)
    LinearLayout mDrivingLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth_user);
        ButterKnife.bind(this);
        mTopBar.setTitle("我的认证");
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @OnClick({R.id.id_card_layout, R.id.drive_layout, R.id.driving_layout})
    public void onViewClicked(View view) {
        Intent intent = new Intent(this, AuthActivity.class);
        switch (view.getId()) {
            case R.id.id_card_layout:
                intent.putExtra(AuthActivity.AUTH_TYPE,AuthActivity.ID_CARD_AUTH);
                break;
            case R.id.drive_layout:
                intent.putExtra(AuthActivity.AUTH_TYPE,AuthActivity.DRIVER_AUTH);
                break;
            case R.id.driving_layout:
                intent.putExtra(AuthActivity.AUTH_TYPE,AuthActivity.DRIVING_AUTH);
                break;
            default:
                break;
        }
        startActivity(intent);
    }
}
