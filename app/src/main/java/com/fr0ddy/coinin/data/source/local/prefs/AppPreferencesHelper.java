package com.fr0ddy.coinin.data.source.local.prefs;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.fr0ddy.coinin.di.PreferenceInfo;

import javax.inject.Inject;

/**
 * Created by gaurav on 17/11/17.
 */

public class AppPreferencesHelper implements PreferencesHelper {

    private final SharedPreferences mPrefs;

    @Inject
    public AppPreferencesHelper(Application context,
                                @PreferenceInfo String prefFileName) {
        mPrefs = context.getApplicationContext().getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }

}
