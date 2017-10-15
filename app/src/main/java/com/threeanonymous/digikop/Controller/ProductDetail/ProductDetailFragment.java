package com.threeanonymous.digikop.Controller.ProductDetail;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.threeanonymous.digikop.R;

/**
 * Created by handyhandy on 9/22/17.
 */

public class ProductDetailFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_product, container, false);



        return view;
    }
}
