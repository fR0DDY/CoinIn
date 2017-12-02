package com.fr0ddy.coinin.di.module;

import com.fr0ddy.coinin.di.ActivityScoped;
import com.fr0ddy.coinin.ui.home.HomeActivity;
import com.fr0ddy.coinin.ui.home.HomeModule;
import com.fr0ddy.coinin.ui.splash.SplashActivity;
import com.fr0ddy.coinin.ui.splash.SplashModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by gaurav on 15/11/17.
 */

@Module
public abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = SplashModule.class)
    abstract SplashActivity splashActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = HomeModule.class)
    abstract HomeActivity bindHomeActivity();
}
