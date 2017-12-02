package com.fr0ddy.coinin.data.source.local.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.fr0ddy.coinin.data.source.local.db.dao.ExchangeDao;
import com.fr0ddy.coinin.data.source.local.db.dao.ExchangeFeesDao;
import com.fr0ddy.coinin.data.source.local.db.dao.ExchangeRateDao;
import com.fr0ddy.coinin.data.source.local.db.model.Exchange;
import com.fr0ddy.coinin.data.source.local.db.model.ExchangeFees;
import com.fr0ddy.coinin.data.source.local.db.model.ExchangeRate;

/**
 * Created by gaurav on 22/11/17.
 */

@Database(entities = {Exchange.class, ExchangeFees.class, ExchangeRate.class}, version = 1)
public abstract class CoinInDatabase extends RoomDatabase {

    public abstract ExchangeDao exchangeDao();

    public abstract ExchangeFeesDao exchangeFeesDao();

    public abstract ExchangeRateDao exchangeRateDao();
}
