package com.threeanonymous.digikop.Utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by handyhandy on 9/22/17.
 */

public class Session {

    public static final String KEY_PHONE_NUMBER = "phone_number";

    private Context context;
    private SharedPreferences sharedPreferences;

    public Session (Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences(Constant.USER_CREDIT,Context.MODE_PRIVATE);
    }

    public void setKeyPhoneNumber(String keyPhoneNumber) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_PHONE_NUMBER,keyPhoneNumber);
        editor.apply();
    }

    public String getKeyPhoneNumber() {
        return sharedPreferences.getString(KEY_PHONE_NUMBER,"");
    }
}
