package com.threeanonymous.digikop.Model;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;

/**
 * Created by handyhandy on 9/23/17.
 */

public class Storage {
    private Context context;

    public Storage(Context context){
        this.context = context;
    }

    public LinkedList<Product> products() {

        LinkedList<Product> products = new LinkedList<>();

        try {
            JSONObject jsonObject = new JSONObject(loadJSONFromAsset());
            JSONArray jsonArray = jsonObject.getJSONArray("product");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonProduct = jsonArray.getJSONObject(i);
                Product product = new Product();
                product.setUid(jsonProduct.getString("uid"));
                product.setName(jsonProduct.getString("name"));
                product.setImageUrl(jsonProduct.getString("imageUrl"));
                product.setPrice(Double.valueOf(jsonProduct.getString("price")));
                product.setStockKeepingUnit(jsonProduct.getString("sku"));
                product.setQuantity(Integer.valueOf(jsonProduct.getString("quantity")));
                product.setUnitName(jsonProduct.getString("unitName"));

                products.add(product);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return products;
    }

    private String loadJSONFromAsset() {
        String json = null;
        try {

            InputStream is = context.getAssets().open("products.json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }


}
