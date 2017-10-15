package com.threeanonymous.digikop.Controller.Buy;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.threeanonymous.digikop.Model.Product;
import com.threeanonymous.digikop.Model.Storage;
import com.threeanonymous.digikop.R;
import com.threeanonymous.digikop.View.TopNavigationHelper;

import java.util.LinkedList;

/**
 * Created by handyhandy on 9/22/17.
 */

public class ProductFragment extends Fragment {

    private LinearLayout linearLayoutTopNavBar;
    private LinkedList<Product> products;
    private GridView gridViewProduct;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product, container, false);

        // setting top navigation bar
        linearLayoutTopNavBar = view.findViewById(R.id.linearLayoutTopNavBar);
        TopNavigationHelper.noBackButton(linearLayoutTopNavBar);

        // get products
        Storage storage = new Storage(getActivity());
        products = storage.products();

        // grid view setting
        gridViewProduct = view.findViewById(R.id.gridViewProduct);
        gridViewProduct.setAdapter(new ProductAdapter(getActivity(),products));

        gridViewProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getActivity(), products.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }


    @Override
    public void onResume() {
        super.onResume();

    }
}
