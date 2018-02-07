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

public class AvatarDialog extends Dialog implements View.OnClickListener {

    private Context mContext = null;
    private final IAvatarListener mListener;
    private TextView mTvAlbum = null;
    private TextView mTvTakePhoto = null;
    private TextView mTvCancel = null;

    public AvatarDialog(@NonNull Context context, IAvatarListener listener) {
        super(context, R.style.Dialog_Animation);
        mContext = context;
        mListener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_avatar);
        initView();
    }

    private void initView() {
        //通过获取到dialog的window来控制dialog的宽高及位置
        LinearLayout relativeLayout = (LinearLayout) LayoutInflater.from(mContext).inflate(R.layout.dialog_avatar, null);
        Window dialogWindow = getWindow();
        dialogWindow.setGravity(Gravity.BOTTOM);
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        //设置宽度
        lp.width = relativeLayout.getResources().getDisplayMetrics().widthPixels;
        dialogWindow.setAttributes(lp);

        mTvAlbum = (TextView) findViewById(R.id.tv_album);
        mTvAlbum.setOnClickListener(this);
        mTvTakePhoto = (TextView) findViewById(R.id.tv_take_photo);
        mTvTakePhoto.setOnClickListener(this);
        mTvCancel = (TextView) findViewById(R.id.tv_cancel);
        mTvCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_album:
                if (mListener != null) {
                    mListener.checkAlbum();
                }
                cancel();
                break;
            case R.id.tv_take_photo:
                if (mListener != null) {
                    mListener.checkTakePhoto();
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

    public interface IAvatarListener {
        /**
         * 相册
         */
        void checkAlbum();

        /**
         * 拍照
         */
        void checkTakePhoto();

    }
}
