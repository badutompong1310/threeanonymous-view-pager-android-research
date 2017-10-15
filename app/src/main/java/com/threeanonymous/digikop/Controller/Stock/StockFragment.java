package com.threeanonymous.digikop.Controller.Stock;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.threeanonymous.digikop.Controller.Home.Home;
import com.threeanonymous.digikop.Controller.Stock.SubCategory.SubCategoryFragment;
import com.threeanonymous.digikop.Controller.Stock.SubCategory.ViewPagerAdapter;
import com.threeanonymous.digikop.R;
import com.threeanonymous.digikop.View.TopNavigationHelper;

/**
 * Created by handyhandy on 10/15/17.
 */

public class StockFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private LinearLayout linearLayoutTopNavBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stock, container, false);

        linearLayoutTopNavBar = view.findViewById(R.id.linearLayoutTopNavBar);
        TopNavigationHelper.noBackButton(linearLayoutTopNavBar);
        TopNavigationHelper.setTitle(linearLayoutTopNavBar,"Stock");

        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(((Home) getActivity()).getSupportFragmentManager());
        viewPagerAdapter.addFragment(SubCategoryFragment.newInstance(0, "Page # 1"), "Page 1");
        viewPagerAdapter.addFragment(SubCategoryFragment.newInstance(1, "Page # 2"), "Page 2");
        viewPagerAdapter.addFragment(SubCategoryFragment.newInstance(2, "Page # 3"), "Page 3");
        viewPager.setAdapter(viewPagerAdapter);


        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }
}
