package com.fr0ddy.coinin.data.repository;

import com.fr0ddy.coinin.data.source.local.db.model.Exchange;
import com.fr0ddy.coinin.data.source.local.db.model.ExchangeFees;

import java.util.List;

/**
 * Created by gaurav on 22/11/17.
 */

public interface ExchangeDataSource {
    List<Long> insertExchanges(List<Exchange> exchanges);

    List<Long> insertExchangeFees(List<ExchangeFees> exchangeFees);

    List<Exchange> getExchanges();

    List<ExchangeFees> getExchangeFees();
}
