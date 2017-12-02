package com.fr0ddy.coinin.data.repository;

import com.fr0ddy.coinin.data.source.Local;
import com.fr0ddy.coinin.data.source.local.db.model.Exchange;
import com.fr0ddy.coinin.data.source.local.db.model.ExchangeFees;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by gaurav on 22/11/17.
 */

@Singleton
public class ExchangeRepository implements ExchangeDataSource {

    private final ExchangeDataSource mExchangeLocalDataSource;

    @Inject
    ExchangeRepository(@Local ExchangeDataSource exchangeLocalDataSource) {
        mExchangeLocalDataSource = exchangeLocalDataSource;
    }

    @Override
    public List<Long> insertExchanges(List<Exchange> exchanges) {
        return mExchangeLocalDataSource.insertExchanges(exchanges);
    }

    @Override
    public List<Long> insertExchangeFees(List<ExchangeFees> exchangeFees) {
        return mExchangeLocalDataSource.insertExchangeFees(exchangeFees);
    }
}
