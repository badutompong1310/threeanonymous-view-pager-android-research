package com.threeanonymous.digikop.Controller;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.threeanonymous.digikop.R;

/**
 * Created by handyhandy on 9/24/17.
 */

public class ScreenLogo extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_screen_logo, container, false);
    }
}
