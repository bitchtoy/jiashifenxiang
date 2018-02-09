package com.sequoia.vehicle.rental.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
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
 * @date 2018/2/9.
 * @funtion
 */

public class AuditConfirmedActivity extends BaseActivity {
    @BindView(R.id.top_bar)
    QMUITopBar mTopBar;
    @BindView(R.id.tv_image)
    TextView mTvImage;
    @BindView(R.id.iv_choose_image)
    ImageView mIvChooseImage;
    @BindView(R.id.image_layout)
    LinearLayout mImageLayout;
    @BindView(R.id.tv_video)
    TextView mTvVideo;
    @BindView(R.id.iv_choose_video)
    ImageView mIvChooseVideo;
    @BindView(R.id.video_layout)
    LinearLayout mVideoLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audit_confirmed);
        ButterKnife.bind(this);
        initTopBar();

        SpannableStringBuilder builder = new SpannableStringBuilder("请确保图片完整，编号、文字、照片均清晰可见");
        builder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, R.color.color_FF5C60)), 5, 16,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTvImage.setText(builder);
        mTvVideo.setText(builder);
    }

    private void initTopBar() {
        mTopBar.setTitle("抵押材料");
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @OnClick({R.id.iv_choose_image, R.id.iv_choose_video})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_choose_image:
                break;
            case R.id.iv_choose_video:
                break;
            default:
                break;
        }
    }
}
