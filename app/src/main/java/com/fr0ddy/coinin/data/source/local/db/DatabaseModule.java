package com.fr0ddy.coinin.data.source.local.db;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.fr0ddy.coinin.data.source.local.db.dao.ExchangeDao;
import com.fr0ddy.coinin.data.source.local.db.dao.ExchangeFeesDao;
import com.fr0ddy.coinin.data.source.local.db.dao.ExchangeRateDao;
import com.fr0ddy.coinin.utils.AppConstants;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by gaurav on 22/11/17.
 */

@Module
public abstract class DatabaseModule {

    private static final String DATABASE = "database_name";

    @Provides
    @Named(DATABASE)
    static String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Singleton
    @Provides
    static CoinInDatabase provideCoinInDatabase(Application context, @Named(DATABASE) String databaseName) {
        return Room.databaseBuilder(context.getApplicationContext(), CoinInDatabase.class, databaseName).build();
    }

    @Singleton
    @Provides
    static ExchangeDao provideExchangeDao(CoinInDatabase coinInDatabase) {
        return coinInDatabase.exchangeDao();
    }

    @Singleton
    @Provides
    static ExchangeFeesDao provideExchangeFeesDao(CoinInDatabase coinInDatabase) {
        return coinInDatabase.exchangeFeesDao();
    }

    @Singleton
    @Provides
    static ExchangeRateDao provideExchangeRateDao(CoinInDatabase coinInDatabase) {
        return coinInDatabase.exchangeRateDao();
    }
}
