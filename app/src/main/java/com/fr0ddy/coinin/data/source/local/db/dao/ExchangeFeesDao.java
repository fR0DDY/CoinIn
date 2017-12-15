package com.fr0ddy.coinin.data.source.local.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.fr0ddy.coinin.data.source.local.db.model.ExchangeFees;

import java.util.List;

/**
 * Created by gaurav on 25/11/17.
 */

@Dao
public interface ExchangeFeesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    List<Long> insertExchangeFees(List<ExchangeFees> exchangeFees);

    @Query("SELECT * FROM ExchangeFees")
    List<ExchangeFees> getExchangeFees();
}
