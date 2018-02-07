package com.sequoia.vehicle.rental.base;

import android.graphics.Color;
import android.support.annotation.LayoutRes;

import com.jaeger.library.StatusBarUtil;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.zhy.autolayout.AutoLayoutActivity;

/**
 * @author Administrator.
 * @date 2018/2/1.
 * @funtion
 */

public class BaseActivity extends AutoLayoutActivity {
    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        setStatusBarColor();
    }

    protected void setStatusBarColor() {
        StatusBarUtil.setColor(this, Color.WHITE, 0);
        QMUIStatusBarHelper.setStatusBarLightMode(this);
    }
}
