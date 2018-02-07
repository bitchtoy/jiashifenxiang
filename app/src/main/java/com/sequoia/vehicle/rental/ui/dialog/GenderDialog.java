package com.sequoia.vehicle.rental.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sequoia.vehicle.rental.R;


/**
 * @author Administrator.
 * @date 2017/12/18.
 * @funtion
 */

public class GenderDialog extends Dialog implements View.OnClickListener {

    private Context mContext = null;
    private final IGenderListener mListener;
    private TextView mTvMale = null;
    private TextView mTvFemale = null;
    private TextView mTvCancel = null;

    public GenderDialog(@NonNull Context context, IGenderListener listener) {
        super(context, R.style.Dialog_Animation);
        mContext = context;
        mListener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_gender);
        initView();
    }

    private void initView() {
        //通过获取到dialog的window来控制dialog的宽高及位置
        LinearLayout relativeLayout = (LinearLayout) LayoutInflater.from(mContext).inflate(R.layout.dialog_gender, null);
        Window dialogWindow = getWindow();
        dialogWindow.setGravity(Gravity.BOTTOM);
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        //设置宽度
        lp.width = relativeLayout.getResources().getDisplayMetrics().widthPixels;
        dialogWindow.setAttributes(lp);

        mTvMale = (TextView) findViewById(R.id.tv_male);
        mTvMale.setOnClickListener(this);
        mTvFemale = (TextView) findViewById(R.id.tv_female);
        mTvFemale.setOnClickListener(this);
        mTvCancel = (TextView) findViewById(R.id.tv_cancel);
        mTvCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_male:
                if (mListener != null) {
                    mListener.checkMale();
                }
                cancel();
                break;
            case R.id.tv_female:
                if (mListener != null) {
                    mListener.checkFemale();
                }
                cancel();
                break;
            case R.id.tv_cancel:
                cancel();
                break;
            default:
                break;
        }
    }

    public interface IGenderListener {
        /**
         * 男
         */
        void checkMale();

        /**
         * 女
         */
        void checkFemale();

    }
}
