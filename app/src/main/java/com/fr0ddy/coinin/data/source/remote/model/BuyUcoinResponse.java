package com.fr0ddy.coinin.data.source.remote.model;

import com.fr0ddy.coinin.data.source.local.db.model.ExchangeRate;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.fr0ddy.coinin.utils.AppConstants.BUYUCOIN_ID;
import static com.fr0ddy.coinin.utils.AppConstants.OXYBIT_ID;

/**
 * Created by gaurav on 16/12/17.
 */

public class BuyUcoinResponse {

    Data data;

    public class Data {
        @SerializedName("ark_inr")
        Price ARK;
        @SerializedName("bat_inr")
        Price BAT;
        @SerializedName("bcc_inr")
        Price BCH;
        @SerializedName("btc_inr")
        Price BTC;
        @SerializedName("bts_inr")
        Price BTS;
        @SerializedName("cloak_inr")
        Price CLOAK;
        @SerializedName("cvc_inr")
        Price CVC;
        @SerializedName("dash_inr")
        Price DASH;
        @SerializedName("dcn_inr")
        Price DCN;
        @SerializedName("dgb_inr")
        Price DGB;
        @SerializedName("doge_inr")
        Price DOGE;
        @SerializedName("etc_inr")
        Price ETC;
        @SerializedName("eth_inr")
        Price ETH;
        @SerializedName("fct_inr")
        Price FCT;
        @SerializedName("gnt_inr")
        Price GNT;
        @SerializedName("lsk_inr")
        Price LSK;
        @SerializedName("ltc_inr")
        Price LTC;
        @SerializedName("neo_inr")
        Price NEO;
        @SerializedName("nxt_inr")
        Price NXT;
        @SerializedName("omg_inr")
        Price OMG;
        @SerializedName("pay_inr")
        Price PAY;
        @SerializedName("pivx_inr")
        Price PIVX;
        @SerializedName("qtum_inr")
        Price QTUM;
        @SerializedName("rep_inr")
        Price REP;
        @SerializedName("sc_inr")
        Price SC;
        @SerializedName("steem_inr")
        Price STEEM;
        @SerializedName("strat_inr")
        Price STRAT;
        @SerializedName("xem_inr")
        Price XEM;
        @SerializedName("xmr_inr")
        Price XMR;
        @SerializedName("xrp_inr")
        Price XRP;
        @SerializedName("zec_inr")
        Price ZEC;
    }

    public class Price {
        @SerializedName("ask")
        Double lowestAsk;
        @SerializedName("bid")
        Double highestBid;

        public Double getLowestAsk() {
            return lowestAsk;
        }

        public void setLowestAsk(Double lowestAsk) {
            this.lowestAsk = lowestAsk;
        }

        public Double getHighestBid() {
            return highestBid;
        }

        public void setHighestBid(Double highestBid) {
            this.highestBid = highestBid;
        }
    }

    public List<ExchangeRate> getExchangeRates(Date date) {
        List<ExchangeRate> exchangeRates = new ArrayList<>();
        //exchangeRates.add(new ExchangeRate(BUYUCOIN_ID, "ARK", date, data.ARK.getLowestAsk(), data.ARK.getHighestBid()));
        //exchangeRates.add(new ExchangeRate(BUYUCOIN_ID, "BAT", date, data.BAT.getLowestAsk(), data.BAT.getHighestBid()));
        exchangeRates.add(new ExchangeRate(BUYUCOIN_ID, "BCH", date, data.BCH.getLowestAsk(), data.BCH.getHighestBid()));
        exchangeRates.add(new ExchangeRate(BUYUCOIN_ID, "BTC", date, data.BTC.getLowestAsk(), data.BTC.getHighestBid()));
        exchangeRates.add(new ExchangeRate(BUYUCOIN_ID, "BTS", date, data.BTS.getLowestAsk(), data.BTS.getHighestBid()));
        //exchangeRates.add(new ExchangeRate(BUYUCOIN_ID, "CLOAK", date, data.CLOAK.getLowestAsk(), data.CLOAK.getHighestBid()));
        //exchangeRates.add(new ExchangeRate(BUYUCOIN_ID, "CVC", date, data.CVC.getLowestAsk(), data.CVC.getHighestBid()));
        //exchangeRates.add(new ExchangeRate(BUYUCOIN_ID, "DASH", date, data.DASH.getLowestAsk(), data.DASH.getHighestBid()));
        //exchangeRates.add(new ExchangeRate(BUYUCOIN_ID, "DCN", date, data.DCN.getLowestAsk(), data.DCN.getHighestBid()));
        //exchangeRates.add(new ExchangeRate(BUYUCOIN_ID, "DGB", date, data.DGB.getLowestAsk(), data.DGB.getHighestBid()));
        //exchangeRates.add(new ExchangeRate(BUYUCOIN_ID, "DOGE", date, data.DOGE.getLowestAsk(), data.DOGE.getHighestBid()));
        //exchangeRates.add(new ExchangeRate(BUYUCOIN_ID, "ETC", date, data.ETC.getLowestAsk(), data.ETC.getHighestBid()));
        exchangeRates.add(new ExchangeRate(BUYUCOIN_ID, "ETH", date, data.ETH.getLowestAsk(), data.ETH.getHighestBid()));
        //exchangeRates.add(new ExchangeRate(BUYUCOIN_ID, "FCT", date, data.FCT.getLowestAsk(), data.FCT.getHighestBid()));
        //exchangeRates.add(new ExchangeRate(BUYUCOIN_ID, "GNT", date, data.GNT.getLowestAsk(), data.GNT.getHighestBid()));
        //exchangeRates.add(new ExchangeRate(BUYUCOIN_ID, "LSK", date, data.LSK.getLowestAsk(), data.LSK.getHighestBid()));
        exchangeRates.add(new ExchangeRate(BUYUCOIN_ID, "LTC", date, data.LTC.getLowestAsk(), data.LTC.getHighestBid()));
        //exchangeRates.add(new ExchangeRate(BUYUCOIN_ID, "NEO", date, data.NEO.getLowestAsk(), data.NEO.getHighestBid()));
        exchangeRates.add(new ExchangeRate(BUYUCOIN_ID, "NXT", date, data.NXT.getLowestAsk(), data.NXT.getHighestBid()));
        //exchangeRates.add(new ExchangeRate(BUYUCOIN_ID, "OMG", date, data.OMG.getLowestAsk(), data.OMG.getHighestBid()));
        //exchangeRates.add(new ExchangeRate(BUYUCOIN_ID, "PAY", date, data.PAY.getLowestAsk(), data.PAY.getHighestBid()));
        //exchangeRates.add(new ExchangeRate(BUYUCOIN_ID, "PIVX", date, data.PIVX.getLowestAsk(), data.PIVX.getHighestBid()));
        //exchangeRates.add(new ExchangeRate(BUYUCOIN_ID, "QTUM", date, data.QTUM.getLowestAsk(), data.QTUM.getHighestBid()));
        //exchangeRates.add(new ExchangeRate(BUYUCOIN_ID, "REP", date, data.REP.getLowestAsk(), data.REP.getHighestBid()));
        //exchangeRates.add(new ExchangeRate(BUYUCOIN_ID, "SC", date, data.SC.getLowestAsk(), data.SC.getHighestBid()));
        exchangeRates.add(new ExchangeRate(BUYUCOIN_ID, "STEEM", date, data.STEEM.getLowestAsk(), data.STEEM.getHighestBid()));
        //exchangeRates.add(new ExchangeRate(BUYUCOIN_ID, "STRAT", date, data.STRAT.getLowestAsk(), data.STRAT.getHighestBid()));
        exchangeRates.add(new ExchangeRate(BUYUCOIN_ID, "XEM", date, data.XEM.getLowestAsk(), data.XEM.getHighestBid()));
        exchangeRates.add(new ExchangeRate(BUYUCOIN_ID, "XMR", date, data.XMR.getLowestAsk(), data.XMR.getHighestBid()));
        exchangeRates.add(new ExchangeRate(BUYUCOIN_ID, "XRP", date, data.XRP.getLowestAsk(), data.XRP.getHighestBid()));
        //exchangeRates.add(new ExchangeRate(BUYUCOIN_ID, "ZEC", date, data.ZEC.getLowestAsk(), data.ZEC.getHighestBid()));
        return exchangeRates;
    }
}
