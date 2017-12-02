package com.fr0ddy.coinin.ui.base;

import com.fr0ddy.coinin.data.source.local.prefs.PreferencesHelper;

import javax.inject.Inject;

/**
 * Created by gaurav on 18/11/17.
 */

public class BaseInteractor implements BaseInteractorContract {

    private final PreferencesHelper mPreferencesHelper;

    @Inject
    public BaseInteractor(PreferencesHelper preferencesHelper) {
        mPreferencesHelper = preferencesHelper;
    }

    @Override
    public PreferencesHelper getPreferencesHelper() {
        return mPreferencesHelper;
    }
}
