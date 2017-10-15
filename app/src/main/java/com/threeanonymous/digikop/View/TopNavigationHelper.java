package com.threeanonymous.digikop.View;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.threeanonymous.digikop.R;

/**
 * Created by handyhandy on 9/22/17.
 */

public class TopNavigationHelper {

    public static void noBackButton(LinearLayout view) {
        if (view.getId() == R.id.linearLayoutTopNavBar) {
            view.getChildAt(0).setVisibility(View.GONE);
        }
    }

    public static void withBackButton(LinearLayout view) {
        if (view.getId() == R.id.linearLayoutTopNavBar) {
            view.getChildAt(0).setVisibility(View.VISIBLE);
            view.getChildAt(1).setPadding(0,0,0,0);
        }
    }

    public static void setTitle(LinearLayout view, String title) {
        if (view.getId() == R.id.linearLayoutTopNavBar) {
            TextView textView = (TextView) ((LinearLayout) view.getChildAt(1)).getChildAt(0);
            textView.setText(title);
        }
    }

}
