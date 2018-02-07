package com.sequoia.vehicle.rental.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * @author Administrator.
 * @date 2018/1/25.
 * @funtion
 */

public abstract class LazyFragment extends BaseFragment {
    /**
     * 标记已加载完成，保证懒加载只能加载一次
     */
    protected boolean isVisible = false;
    /**
     * 是否准备完成
     */
    private boolean isPrepared = false;
    /**
     * 是否是第一次加载数据
     */
    private boolean hasLoaded = false;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            lazyLoadData();//可见时执行
        } else {
            isVisible = false;
            onInVisible(); //不可见是执行
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isPrepared = true;
        lazyLoadData();
    }

    /**
     * 不可见时执行具体的方法
     */
    protected void onInVisible() {

    }

    protected void lazyLoadData() {
        //当onActivityCreated（）和setUserVisibleHint()这两个方法都执行之后才会去加载数据
        if (hasLoaded || !isVisible || !isPrepared) {
            return;
        }
        initData();
        hasLoaded = true;
    }

    /**
     * 用来加载数据的抽象方法
     */
    public abstract void initData();
}
