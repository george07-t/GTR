package com.example.cse;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class sessionmanager {
    private static String TAG=sessionmanager.class.getSimpleName();
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;
    int PRIVATE_MODE=0;
    private static final String PREF_NAME="AndroidHiveLogin";
    private static final String KEY_Is_LOGGED_IN="isLoggedIn";
    public sessionmanager(Context context)
    {
        this._context=context;
        pref=_context.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        editor=pref.edit();
    }
    public void setLogin(boolean isLoggedIn)
    {
        editor.putBoolean(KEY_Is_LOGGED_IN,isLoggedIn);
        editor.commit();
        Log.d(TAG,"User Login session modified");
    }
    public boolean isLoogedIn()
    {
        return pref.getBoolean(KEY_Is_LOGGED_IN,false);
    }
}
