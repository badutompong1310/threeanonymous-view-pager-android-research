package com.threeanonymous.digikop.Controller.Home;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.threeanonymous.digikop.Controller.BaseActivity;
import com.threeanonymous.digikop.Controller.Buy.ProductFragment;
import com.threeanonymous.digikop.Controller.ScreenLogo;
import com.threeanonymous.digikop.Controller.Status.StatusFragment;
import com.threeanonymous.digikop.Controller.Stock.StockFragment;
import com.threeanonymous.digikop.R;
import com.threeanonymous.digikop.View.BottomNavigationHelper;

public class Home extends BaseActivity {

    private BottomNavigationView bottomNavView;
    private FrameLayout frameLayout;
    private FragmentManager fragmentManager;
    // fragment tagging
    public static final String SCREEN_LOGO_TAG = "screen_logo";
    public static final String PRODUCT_TAG = "product";
    public static final String STATUS_TAG = "status";
    public static final String STOCK_TAG = "stock";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavView = (BottomNavigationView) findViewById(R.id.bottomNavView);
        BottomNavigationHelper.disableShiftMode(bottomNavView);


        frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
        fragmentManager = getFragmentManager();

//        fragmentManager.popBackStack();
        unSelectableBottomNavViewItem();

        if (savedInstanceState == null) {
            ScreenLogo screenLogo = new ScreenLogo();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(frameLayout.getId(), screenLogo, SCREEN_LOGO_TAG);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }

        bottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectableBottomNavViewItem();
                switch (item.getItemId()) {
                    case R.id.buy_bottom_nav: {
                        ProductFragment productFragment = new ProductFragment();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(frameLayout.getId() , productFragment, PRODUCT_TAG);
                        fragmentTransaction.addToBackStack(SCREEN_LOGO_TAG);
                        fragmentTransaction.commit();
                        return true;
                    } case R.id.stock_bottom_nav: {
                        StockFragment stockFragment = new StockFragment();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(frameLayout.getId(), stockFragment, STOCK_TAG);
                        fragmentTransaction.addToBackStack(SCREEN_LOGO_TAG);
                        fragmentTransaction.commit();
                        return true;
                    } case R.id.status_bottom_nav: {
                        StatusFragment statusFragment = new StatusFragment();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(frameLayout.getId(), statusFragment, STATUS_TAG);
                        fragmentTransaction.addToBackStack(SCREEN_LOGO_TAG);
                        fragmentTransaction.commit();
                        return true;
                    } case R.id.input_bottom_nav: {
                        fragmentManager.popBackStack(SCREEN_LOGO_TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                        return true;
                    }
                }

                return false;
            }
        });



    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }

    private void unSelectableBottomNavViewItem() {
        int size = bottomNavView.getMenu().size();
        for (int i = 0; i < size; i++) {
            bottomNavView.getMenu().getItem(i).setCheckable(false);
        }
    }

    private void selectableBottomNavViewItem() {
        int size = bottomNavView.getMenu().size();
        for (int i = 0; i < size; i++) {
            bottomNavView.getMenu().getItem(i).setCheckable(true);
        }
    }

}
