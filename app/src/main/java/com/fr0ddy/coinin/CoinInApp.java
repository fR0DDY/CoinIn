package com.fr0ddy.coinin;

import com.fr0ddy.coinin.di.component.ApplicationComponent;
import com.fr0ddy.coinin.di.component.DaggerApplicationComponent;
import com.squareup.leakcanary.LeakCanary;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import timber.log.Timber;

/**
 * Created by gaurav on 20/09/17.
 */

public class CoinInApp extends DaggerApplication {

    private ApplicationComponent mApplicationComponent;

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        mApplicationComponent = DaggerApplicationComponent.builder().application(this).build();
        return mApplicationComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
