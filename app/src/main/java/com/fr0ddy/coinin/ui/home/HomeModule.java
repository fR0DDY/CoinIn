package com.fr0ddy.coinin.ui.home;

import com.fr0ddy.coinin.di.ActivityScoped;

import dagger.Module;
import dagger.Provides;

/**
 * Created by gaurav on 15/11/17.
 */

@Module
public class HomeModule {

    @ActivityScoped
    @Provides
    HomeContract.Presenter<HomeContract.View, HomeContract.Interactor> provideHomePresenter(
            HomePresenter<HomeContract.View, HomeContract.Interactor> presenter) {
        return presenter;
    }

    @Provides
    HomeContract.Interactor provideHomeInteractor(HomeInteractor interactor) {
        return interactor;
    }
}
