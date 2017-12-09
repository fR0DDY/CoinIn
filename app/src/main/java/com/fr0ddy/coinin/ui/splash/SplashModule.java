package com.fr0ddy.coinin.ui.splash;

import dagger.Binds;
import dagger.Module;

/**
 * Created by gaurav on 15/11/17.
 */

@Module
abstract public class SplashModule {

    @Binds
    abstract SplashContract.Presenter<SplashContract.View, SplashContract.Interactor> provideSplashPresenter(
            SplashPresenter<SplashContract.View, SplashContract.Interactor> presenter);

    @Binds
    abstract SplashContract.Interactor provideSplashInteractor(SplashInteractor interactor);
}
