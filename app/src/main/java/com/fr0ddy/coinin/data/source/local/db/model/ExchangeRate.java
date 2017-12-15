package com.fr0ddy.coinin.data.source.local.db.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.fr0ddy.coinin.data.source.local.db.DateConverter;

import java.util.Date;

/**
 * Created by gaurav on 25/11/17.
 */

@Entity(foreignKeys = {
        @ForeignKey(entity = Exchange.class,
                parentColumns = "id",
                childColumns = "exchangeId",
                onDelete = ForeignKey.CASCADE)},
        indices = {@Index(value = "exchangeId")})
public class ExchangeRate {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private int exchangeId;
    private String currency;
    @TypeConverters(DateConverter.class)
    private Date dateTime;
    private double buyRate;
    private double sellRate;

    public ExchangeRate() {
    }

    public ExchangeRate(int exchangeId, String currency, Date dateTime, double buyRate, double sellRate) {
        this.exchangeId = exchangeId;
        this.currency = currency;
        this.dateTime = dateTime;
        this.buyRate = buyRate;
        this.sellRate = sellRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(int exchangeId) {
        this.exchangeId = exchangeId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getBuyRate() {
        return buyRate;
    }

    public void setBuyRate(double buyRate) {
        this.buyRate = buyRate;
    }

    public double getSellRate() {
        return sellRate;
    }

    public void setSellRate(double sellRate) {
        this.sellRate = sellRate;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "ExchangeRate{" +
                "id=" + id +
                ", exchangeId=" + exchangeId +
                ", currency='" + currency + '\'' +
                ", dateTime=" + dateTime +
                ", buyRate=" + buyRate +
                ", sellRate=" + sellRate +
                '}';
    }
}
