package com.fr0ddy.coinin.data.source.local.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.fr0ddy.coinin.data.source.local.db.model.CurrentExchangeRate;
import com.fr0ddy.coinin.data.source.local.db.model.ExchangeRate;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by gaurav on 25/11/17.
 */

@Dao
public interface ExchangeRateDao {

    @Insert
    List<Long> insertExchangeRates(List<ExchangeRate> exchangeRates);

    @Query("SELECT * FROM ExchangeRate GROUP BY exchangeId, currency ORDER BY dateTime DESC")
    Flowable<List<ExchangeRate>> getRates();

    @Query("SELECT ExchangeRate.*, Exchange.name as exchangeName FROM ExchangeRate JOIN Exchange on ExchangeRate.exchangeId = Exchange.id WHERE currency = :currency GROUP BY exchangeId ORDER BY dateTime DESC, buyRate ASC, sellRate DESC")
    Flowable<List<CurrentExchangeRate>> getRatesForCurrency(String currency);

    @Query("SELECT * FROM ExchangeRate WHERE exchangeId = :exchangeId and currency = :currency ORDER BY dateTime DESC LIMIT 1")
    Flowable<ExchangeRate> getRatesForCurrencyFromExchange(String currency, Long exchangeId);
}
