package com.fr0ddy.coinin.data.source.local.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.fr0ddy.coinin.data.source.local.db.model.Exchange;
import com.fr0ddy.coinin.data.source.local.db.model.ExchangeFees;

import java.util.List;

/**
 * Created by gaurav on 21/11/17.
 */

@Dao
public interface ExchangeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    List<Long> insertExchanges(List<Exchange> exchanges);

    @Query("SELECT * FROM Exchange")
    List<Exchange> getExchange();
}
