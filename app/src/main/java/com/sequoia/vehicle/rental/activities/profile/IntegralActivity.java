package com.sequoia.vehicle.rental.activities.profile;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

import com.qmuiteam.qmui.widget.QMUITopBar;
import com.sequoia.vehicle.rental.R;
import com.sequoia.vehicle.rental.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Administrator.
 * @date 2018/1/25.
 * @funtion 我的积分
 */

public class IntegralActivity extends BaseActivity {
    public static final String INTEGRAL = "INTEGRAL";
    @BindView(R.id.top_bar)
    QMUITopBar mTopBar;
    @BindView(R.id.tv_integral)
    TextView mTvIntegral;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    private int mIntegral = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_integral);
        ButterKnife.bind(this);
        mIntegral = getIntent().getIntExtra(INTEGRAL, 0);
        initTopBar();
        @SuppressLint("DefaultLocale") SpannableStringBuilder builder =
                new SpannableStringBuilder(String.format("可用积分：%d（积分可用于租车租金的减免）", mIntegral));
        builder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, R.color.color_FF5C60)), 5, builder.length() - 14,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTvIntegral.setText(builder);
    }

    private void initTopBar() {
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mTopBar.setTitle("我的积分");
    }
}
