package com.threeanonymous.digikop.Controller.Buy;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.threeanonymous.digikop.Model.Product;
import com.threeanonymous.digikop.R;

import java.util.LinkedList;

/**
 * Created by handyhandy on 9/24/17.
 */

public class ProductAdapter extends BaseAdapter {
    private Context context;
    private ProductHolder productHolder;
    private LinkedList<Product> products;

    public ProductAdapter(Context context, LinkedList<Product> products){
        this.context = context;
        this.products = products;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_product, viewGroup, false);
            productHolder = new ProductHolder();
            productHolder.productItemImage = view.findViewById(R.id.productItemImage);
            productHolder.productItemName = view.findViewById(R.id.productItemName);
            productHolder.productItemStock = view.findViewById(R.id.productItemStock);
            productHolder.productItemPrice = view.findViewById(R.id.productItemPrice);

            view.setTag(productHolder);

        } else {
            productHolder = (ProductHolder) view.getTag();
        }

        final Product product = products.get(position);

        // setting image
        Integer resourceID = context.getResources().getIdentifier(product.getImageUrl(),"drawable",
                context.getPackageName());
        productHolder.productItemImage.setImageResource(resourceID);

        // setting product name
        productHolder.productItemName.setText(product.getName());

        // setting stock
        String stock = "Stock: " + product.getQuantity() + " " + product.getUnitName();
        productHolder.productItemStock.setText(stock);

        // setting price
        String price = "IDR " + String.format("%,.2f",product.getPrice());
        productHolder.productItemPrice.setText(price);

        return view;
    }

    private class ProductHolder {
        ImageView productItemImage;
        TextView productItemName, productItemStock, productItemPrice;
    }
}


















