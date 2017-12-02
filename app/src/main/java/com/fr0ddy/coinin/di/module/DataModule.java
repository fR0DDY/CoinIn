package com.fr0ddy.coinin.di.module;

import com.fr0ddy.coinin.data.repository.ExchangeDataSource;
import com.fr0ddy.coinin.data.repository.ExchangeRateDataSource;
import com.fr0ddy.coinin.data.source.Local;
import com.fr0ddy.coinin.data.source.Remote;
import com.fr0ddy.coinin.data.source.local.db.ExchangeLocalDataSource;
import com.fr0ddy.coinin.data.source.local.db.ExchangeRateLocalDataSource;
import com.fr0ddy.coinin.data.source.remote.ExchangeRateRemoteDataSource;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

/**
 * Created by gaurav on 22/11/17.
 */

@Module
abstract public class DataModule {

    @Singleton
    @Binds
    @Local
    abstract ExchangeDataSource provideExchangeLocalDataSource(ExchangeLocalDataSource exchangeLocalDataSource);

    @Singleton
    @Binds
    @Local
    abstract ExchangeRateDataSource provideExchangeRateLocalDataSource(ExchangeRateLocalDataSource exchangeRateLocalDataSource);

    @Singleton
    @Binds
    @Remote
    abstract ExchangeRateDataSource provideExchangeRateRemoteDataSource(ExchangeRateRemoteDataSource exchangeRateRemoteDataSource);
}
