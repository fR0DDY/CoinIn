package com.fr0ddy.coinin.data.source.local.db;

import android.support.annotation.NonNull;

import com.fr0ddy.coinin.data.repository.ExchangeDataSource;
import com.fr0ddy.coinin.data.source.local.db.dao.ExchangeDao;
import com.fr0ddy.coinin.data.source.local.db.dao.ExchangeFeesDao;
import com.fr0ddy.coinin.data.source.local.db.model.Exchange;
import com.fr0ddy.coinin.data.source.local.db.model.ExchangeFees;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by gaurav on 22/11/17.
 */

@Singleton
public class ExchangeLocalDataSource implements ExchangeDataSource {

    private final ExchangeDao mExchangeDao;
    private final ExchangeFeesDao mExchangeFeesDao;

    @Inject
    public ExchangeLocalDataSource(@NonNull ExchangeDao exchangeDao, @NonNull ExchangeFeesDao exchangeFeesDao) {
        mExchangeDao = exchangeDao;
        mExchangeFeesDao = exchangeFeesDao;
    }

    @Override
    public List<Long> insertExchanges(List<Exchange> exchanges) {
        return mExchangeDao.insertExchanges(exchanges);
    }

    @Override
    public List<Long> insertExchangeFees(List<ExchangeFees> exchangeFees) {
        return mExchangeFeesDao.insertExchangeFees(exchangeFees);
    }
}
