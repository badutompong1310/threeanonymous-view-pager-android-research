package com.threeanonymous.digikop.Controller.Stock.SubCategory;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.LinkedList;

/**
 * Created by handyhandy on 10/15/17.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private final LinkedList<Fragment> mFragmentList = new LinkedList<>();
    private final LinkedList<String> mFragmentTitleList = new LinkedList<>();


    public ViewPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }


    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }

    public void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }


}
