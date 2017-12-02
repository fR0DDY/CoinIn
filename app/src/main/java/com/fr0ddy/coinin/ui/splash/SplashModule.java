package com.fr0ddy.coinin.ui.splash;

import dagger.Module;
import dagger.Provides;

/**
 * Created by gaurav on 15/11/17.
 */

@Module
public class SplashModule {

    @Provides
    SplashContract.Presenter<SplashContract.View, SplashContract.Interactor> provideSplashPresenter(
            SplashPresenter<SplashContract.View, SplashContract.Interactor> presenter) {
        return presenter;
    }

    @Provides
    SplashContract.Interactor provideSplashInteractor(SplashInteractor interactor) {
        return interactor;
    }
}
