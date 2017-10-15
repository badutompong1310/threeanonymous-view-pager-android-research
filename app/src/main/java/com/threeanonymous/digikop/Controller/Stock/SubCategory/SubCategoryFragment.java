package com.threeanonymous.digikop.Controller.Stock.SubCategory;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.threeanonymous.digikop.R;

/**
 * Created by handyhandy on 10/15/17.
 */

public class SubCategoryFragment extends Fragment {

    // Store instance variables
    private String title;
    private int page;
    private LinearLayout linearLayout;

    public static SubCategoryFragment newInstance(int page, String title) {
        SubCategoryFragment subCategoryFragment = new SubCategoryFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        subCategoryFragment.setArguments(args);
        return subCategoryFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sub_category, container, false);
        linearLayout = (LinearLayout) view.findViewById(R.id.linearLayout);

        TextView tvLabel = new TextView(getActivity().getApplicationContext());
        tvLabel.setText(page + " -- " + title);

        linearLayout.addView(tvLabel);
        return view;
    }

}
