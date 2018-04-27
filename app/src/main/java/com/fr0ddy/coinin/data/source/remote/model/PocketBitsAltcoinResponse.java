package com.fr0ddy.coinin.data.source.remote.model;

import com.fr0ddy.coinin.data.source.local.db.model.ExchangeRate;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.fr0ddy.coinin.utils.AppConstants.POCKETBITS_ID;

/**
 * Created by gaurav on 27/12/17.
 */

public class PocketBitsAltcoinResponse {
    @SerializedName("CurBuyRate")
    String buyPrice;
    @SerializedName("CurSellRate")
    String sellPrice;
    @SerializedName("MarketName")
    String marketName;

    public String getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(String buyPrice) {
        this.buyPrice = buyPrice;
    }

    public String getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(String sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public static List<ExchangeRate> getExchangeRates(List<PocketBitsAltcoinResponse> pocketBitsAltcoinResponses, Date date) {
        List<ExchangeRate> exchangeRates = new ArrayList<>();
        for (PocketBitsAltcoinResponse response : pocketBitsAltcoinResponses) {
            if ("BCC".equalsIgnoreCase(response.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(POCKETBITS_ID, "BCH", date, Double.parseDouble(response.getBuyPrice()), Double.parseDouble(response.getSellPrice()));
                exchangeRates.add(rate);
            } else if ("BTG".equalsIgnoreCase(response.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(POCKETBITS_ID, "BTG", date, Double.parseDouble(response.getBuyPrice()), Double.parseDouble(response.getSellPrice()));
                exchangeRates.add(rate);
            } else if ("DGB".equalsIgnoreCase(response.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(POCKETBITS_ID, "DGB", date, Double.parseDouble(response.getBuyPrice()), Double.parseDouble(response.getSellPrice()));
                exchangeRates.add(rate);
            } else if ("XLM".equalsIgnoreCase(response.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(POCKETBITS_ID, "XLM", date, Double.parseDouble(response.getBuyPrice()), Double.parseDouble(response.getSellPrice()));
                exchangeRates.add(rate);
            } else if ("ETH".equalsIgnoreCase(response.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(POCKETBITS_ID, "ETH", date, Double.parseDouble(response.getBuyPrice()), Double.parseDouble(response.getSellPrice()));
                exchangeRates.add(rate);
            } else if ("LTC".equalsIgnoreCase(response.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(POCKETBITS_ID, "LTC", date, Double.parseDouble(response.getBuyPrice()), Double.parseDouble(response.getSellPrice()));
                exchangeRates.add(rate);
            } else if ("XRP".equalsIgnoreCase(response.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(POCKETBITS_ID, "XRP", date, Double.parseDouble(response.getBuyPrice()), Double.parseDouble(response.getSellPrice()));
                exchangeRates.add(rate);
            } else if ("DASH".equalsIgnoreCase(response.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(POCKETBITS_ID, "DASH", date, Double.parseDouble(response.getBuyPrice()), Double.parseDouble(response.getSellPrice()));
                exchangeRates.add(rate);
            } else if ("ETC".equalsIgnoreCase(response.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(POCKETBITS_ID, "ETC", date, Double.parseDouble(response.getBuyPrice()), Double.parseDouble(response.getSellPrice()));
                exchangeRates.add(rate);
            } else if ("XMR".equalsIgnoreCase(response.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(POCKETBITS_ID, "XMR", date, Double.parseDouble(response.getBuyPrice()), Double.parseDouble(response.getSellPrice()));
                exchangeRates.add(rate);
            } else if ("NEO".equalsIgnoreCase(response.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(POCKETBITS_ID, "NEO", date, Double.parseDouble(response.getBuyPrice()), Double.parseDouble(response.getSellPrice()));
                exchangeRates.add(rate);
            } else if ("OMG".equalsIgnoreCase(response.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(POCKETBITS_ID, "OMG", date, Double.parseDouble(response.getBuyPrice()), Double.parseDouble(response.getSellPrice()));
                exchangeRates.add(rate);
            } else if ("ZEC".equalsIgnoreCase(response.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(POCKETBITS_ID, "ZEC", date, Double.parseDouble(response.getBuyPrice()), Double.parseDouble(response.getSellPrice()));
                exchangeRates.add(rate);
            } else if ("SC".equalsIgnoreCase(response.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(POCKETBITS_ID, "SC", date, Double.parseDouble(response.getBuyPrice()), Double.parseDouble(response.getSellPrice()));
                exchangeRates.add(rate);
            } else if ("XVG".equalsIgnoreCase(response.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(POCKETBITS_ID, "XVG", date, Double.parseDouble(response.getBuyPrice()), Double.parseDouble(response.getSellPrice()));
                exchangeRates.add(rate);
            } else if ("VOX".equalsIgnoreCase(response.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(POCKETBITS_ID, "VOX", date, Double.parseDouble(response.getBuyPrice()), Double.parseDouble(response.getSellPrice()));
                exchangeRates.add(rate);
            } else if ("TRX".equalsIgnoreCase(response.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(POCKETBITS_ID, "TRX", date, Double.parseDouble(response.getBuyPrice()), Double.parseDouble(response.getSellPrice()));
                exchangeRates.add(rate);
            } else if ("ZRX".equalsIgnoreCase(response.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(POCKETBITS_ID, "ZRX", date, Double.parseDouble(response.getBuyPrice()), Double.parseDouble(response.getSellPrice()));
                exchangeRates.add(rate);
            } else if ("REP".equalsIgnoreCase(response.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(POCKETBITS_ID, "REP", date, Double.parseDouble(response.getBuyPrice()), Double.parseDouble(response.getSellPrice()));
                exchangeRates.add(rate);
            } else if ("BAT".equalsIgnoreCase(response.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(POCKETBITS_ID, "BAT", date, Double.parseDouble(response.getBuyPrice()), Double.parseDouble(response.getSellPrice()));
                exchangeRates.add(rate);
            } else if ("QTUM".equalsIgnoreCase(response.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(POCKETBITS_ID, "QTUM", date, Double.parseDouble(response.getBuyPrice()), Double.parseDouble(response.getSellPrice()));
                exchangeRates.add(rate);
            } else if ("ADA".equalsIgnoreCase(response.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(POCKETBITS_ID, "ADA", date, Double.parseDouble(response.getBuyPrice()), Double.parseDouble(response.getSellPrice()));
                exchangeRates.add(rate);
            } else if ("DOGE".equalsIgnoreCase(response.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(POCKETBITS_ID, "DOGE", date, Double.parseDouble(response.getBuyPrice()), Double.parseDouble(response.getSellPrice()));
                exchangeRates.add(rate);
            } else if ("GNT".equalsIgnoreCase(response.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(POCKETBITS_ID, "GNT", date, Double.parseDouble(response.getBuyPrice()), Double.parseDouble(response.getSellPrice()));
                exchangeRates.add(rate);
            } else if ("STORJ".equalsIgnoreCase(response.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(POCKETBITS_ID, "STORJ", date, Double.parseDouble(response.getBuyPrice()), Double.parseDouble(response.getSellPrice()));
                exchangeRates.add(rate);
            } else if ("UBQ".equalsIgnoreCase(response.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(POCKETBITS_ID, "UBQ", date, Double.parseDouble(response.getBuyPrice()), Double.parseDouble(response.getSellPrice()));
                exchangeRates.add(rate);
            }
        }
        return exchangeRates;
    }
}
