package com.fr0ddy.coinin.data.source.local.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

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

    @Query("SELECT * FROM ExchangeRate WHERE currency = :currency GROUP BY exchangeId ORDER BY dateTime DESC, buyRate ASC, sellRate DESC")
    Flowable<List<ExchangeRate>> getRatesForCurrency(String currency);
}
