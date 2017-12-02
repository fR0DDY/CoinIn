package com.fr0ddy.coinin.di.module;

import android.app.Application;
import android.content.Context;

import com.fr0ddy.coinin.data.source.local.prefs.AppPreferencesHelper;
import com.fr0ddy.coinin.data.source.local.prefs.PreferencesHelper;
import com.fr0ddy.coinin.di.PreferenceInfo;
import com.fr0ddy.coinin.utils.AppConstants;
import com.fr0ddy.coinin.utils.rx.AppSchedulerProvider;
import com.fr0ddy.coinin.utils.rx.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Created by gaurav on 12/06/17.
 */

@Module
public abstract class ApplicationModule {

    @Binds
    abstract Context bindContext(Application application);

    @Provides
    static SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @PreferenceInfo
    static String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Binds
    @Singleton
    abstract PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper);
}
