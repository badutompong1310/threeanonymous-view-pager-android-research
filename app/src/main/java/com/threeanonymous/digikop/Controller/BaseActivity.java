package com.threeanonymous.digikop.Controller;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;

import com.threeanonymous.digikop.Model.Storage;
import com.threeanonymous.digikop.R;
import com.threeanonymous.digikop.Utils.Session;
import com.threeanonymous.digikop.View.BottomNavigationHelper;

/**
 * Created by handyhandy on 9/22/17.
 */

public class BaseActivity extends AppCompatActivity {

    public Session session;
    public Storage storage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        session = new Session(this);
        storage = new Storage(this);
    }


}
