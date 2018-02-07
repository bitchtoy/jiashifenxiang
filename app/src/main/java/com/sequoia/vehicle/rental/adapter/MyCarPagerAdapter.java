package com.sequoia.vehicle.rental.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * @author Administrator.
 * @date 2018/1/25.
 * @funtion
 */

public class MyCarPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> mFragments = null;
    private String[] mTitle = null;

    public MyCarPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments, String[] title) {
        super(fm);
        mFragments = fragments;
        mTitle = title;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = mFragments.get(position);
        return fragment;
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle[position];
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
    }
}
