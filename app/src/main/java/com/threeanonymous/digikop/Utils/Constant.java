package com.threeanonymous.digikop.Utils;

import android.os.Environment;

import java.io.File;

/**
 * Created by handyhandy on 9/22/17.
 */

public class Constant {

    public static String USER_CREDIT = "com.threeanonymous.digikop";
    public static String FONT_REGULER = "";
    public static String FONT_BOLD = "";

    public static String BASE_PATH =
            Environment.getExternalStorageDirectory().toString() + File.separator
                    + "DigiKOP";

}
