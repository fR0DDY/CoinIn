package com.fr0ddy.coinin.ui.home;

import android.support.v7.widget.LinearLayoutManager;

import com.fr0ddy.coinin.data.source.local.db.model.CurrentExchangeRate;
import com.fr0ddy.coinin.data.source.local.db.model.ExchangeRate;
import com.fr0ddy.coinin.di.FragmentScoped;

import java.util.ArrayList;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by gaurav on 15/11/17.
 */

@Module
abstract public class HomeModule {

    @Provides
    static HomePagerAdapter provideHomePagerAdapter(HomeActivity activity) {
        return new HomePagerAdapter(activity.getSupportFragmentManager());
    }

    @FragmentScoped
    @ContributesAndroidInjector
    abstract CurrencyFragment currencyFragment();

    @Binds
    abstract CurrencyContract.Presenter<CurrencyContract.View, CurrencyContract.Interactor> provideCurrencyPresenter(
            CurrencyPresenter<CurrencyContract.View, CurrencyContract.Interactor> presenter);

    @Binds
    abstract CurrencyContract.Interactor provideCurrencyInteractor(CurrencyInteractor interactor);

    @Provides
    static LinearLayoutManager provideLinearLayoutManager(HomeActivity activity) {
        return new LinearLayoutManager(activity);
    }

    @Provides
    static ExchangeRateAdapter provideExchangeRateAdapter() {
        return new ExchangeRateAdapter(new ArrayList<CurrentExchangeRate>());
    }

}
