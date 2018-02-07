package com.sequoia.vehicle.rental.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.blankj.utilcode.util.Utils;
import com.lzy.okgo.OkGo;
import com.zhy.autolayout.config.AutoLayoutConifg;

import java.util.ArrayList;

/**
 * @author Administrator.
 * @date 2018/2/1.
 * @funtion
 */

public class App extends Application implements Application.ActivityLifecycleCallbacks {

    private ArrayList<Activity> mActivities = null;

    @Override
    public void onCreate() {
        super.onCreate();
        mActivities = new ArrayList<>();
        Utils.init(this);
        OkGo.getInstance().init(this);
        AutoLayoutConifg.getInstance().useDeviceSize();
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        if (mActivities != null) {
            mActivities.add(activity);
        }
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        if (mActivities != null) {
            mActivities.remove(activity);
        }
    }
}
