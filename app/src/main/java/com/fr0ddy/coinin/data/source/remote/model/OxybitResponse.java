package com.fr0ddy.coinin.data.source.remote.model;

import com.fr0ddy.coinin.data.source.local.db.model.ExchangeRate;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.fr0ddy.coinin.utils.AppConstants.OXYBIT_ID;

/**
 * Created by gaurav on 28/02/18.
 */

public class OxybitResponse {

    @SerializedName("btc-inr")
    Data BTC;
    @SerializedName("eth-inr")
    Data ETH;
    @SerializedName("xrp-inr")
    Data XRP;
    @SerializedName("ltc-inr")
    Data LTC;
    @SerializedName("bch-inr")
    Data BCH;
    @SerializedName("xlm-inr")
    Data XLM;
    @SerializedName("eos-inr")
    Data EOS;
    @SerializedName("dash-inr")
    Data DASH;
    @SerializedName("xmr-inr")
    Data XMR;
    @SerializedName("trx-inr")
    Data TRX;
    @SerializedName("vet-inr")
    Data VET;
    @SerializedName("omg-inr")
    Data OMG;
    @SerializedName("nano-inr")
    Data NANO;
    @SerializedName("snt-inr")
    Data SNT;
    @SerializedName("rep-inr")
    Data REP;
    @SerializedName("zrx-inr")
    Data ZRX;
    @SerializedName("bat-inr")
    Data BAT;
    @SerializedName("gnt-inr")
    Data GNT;
    @SerializedName("knc-inr")
    Data KNC;
    @SerializedName("fun-inr")
    Data FUN;
    @SerializedName("salt-inr")
    Data SALT;
    @SerializedName("bnt-inr")
    Data BNT;
    @SerializedName("req-inr")
    Data REQ;
    @SerializedName("san-inr")
    Data SAN;
    @SerializedName("gno-inr")
    Data GNO;
    @SerializedName("icn-inr")
    Data ICN;
    @SerializedName("poe-inr")
    Data POE;
    @SerializedName("cvc-inr")
    Data CVC;
    @SerializedName("storj-inr")
    Data STORJ;
    @SerializedName("mco-inr")
    Data MCO;
    @SerializedName("ant-inr")
    Data ANT;

    public class Data {
        @SerializedName("askprice")
        Double lowestAsk;
        @SerializedName("bidprice")
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

        @Override
        public String toString() {
            return "Data{" +
                    ", lowestAsk='" + lowestAsk + '\'' +
                    ", highestBid='" + highestBid + '\'' +
                    '}';
        }
    }

    public List<ExchangeRate> getExchangeRates(Date date) {
        List<ExchangeRate> exchangeRates = new ArrayList<>();
        exchangeRates.add(new ExchangeRate(OXYBIT_ID, "BTC", date, BTC.getLowestAsk(), BTC.getHighestBid()));
        exchangeRates.add(new ExchangeRate(OXYBIT_ID, "ETH", date, ETH.getLowestAsk(), ETH.getHighestBid()));
        exchangeRates.add(new ExchangeRate(OXYBIT_ID, "XRP", date, XRP.getLowestAsk(), XRP.getHighestBid()));
        exchangeRates.add(new ExchangeRate(OXYBIT_ID, "LTC", date, LTC.getLowestAsk(), LTC.getHighestBid()));
        exchangeRates.add(new ExchangeRate(OXYBIT_ID, "BCH", date, BCH.getLowestAsk(), BCH.getHighestBid()));
        exchangeRates.add(new ExchangeRate(OXYBIT_ID, "XLM", date, XLM.getLowestAsk(), XLM.getHighestBid()));
        exchangeRates.add(new ExchangeRate(OXYBIT_ID, "EOS", date, EOS.getLowestAsk(), EOS.getHighestBid()));
        exchangeRates.add(new ExchangeRate(OXYBIT_ID, "DASH", date, DASH.getLowestAsk(), DASH.getHighestBid()));
        exchangeRates.add(new ExchangeRate(OXYBIT_ID, "XMR", date, XMR.getLowestAsk(), XMR.getHighestBid()));
        exchangeRates.add(new ExchangeRate(OXYBIT_ID, "TRX", date, TRX.getLowestAsk(), TRX.getHighestBid()));
        exchangeRates.add(new ExchangeRate(OXYBIT_ID, "VET", date, VET.getLowestAsk(), VET.getHighestBid()));
        exchangeRates.add(new ExchangeRate(OXYBIT_ID, "OMG", date, OMG.getLowestAsk(), OMG.getHighestBid()));
        exchangeRates.add(new ExchangeRate(OXYBIT_ID, "NANO", date, NANO.getLowestAsk(), NANO.getHighestBid()));
        exchangeRates.add(new ExchangeRate(OXYBIT_ID, "SNT", date, SNT.getLowestAsk(), SNT.getHighestBid()));
        exchangeRates.add(new ExchangeRate(OXYBIT_ID, "REP", date, REP.getLowestAsk(), REP.getHighestBid()));
        exchangeRates.add(new ExchangeRate(OXYBIT_ID, "ZRX", date, ZRX.getLowestAsk(), ZRX.getHighestBid()));
        exchangeRates.add(new ExchangeRate(OXYBIT_ID, "BAT", date, BAT.getLowestAsk(), BAT.getHighestBid()));
        exchangeRates.add(new ExchangeRate(OXYBIT_ID, "GNT", date, GNT.getLowestAsk(), GNT.getHighestBid()));
        exchangeRates.add(new ExchangeRate(OXYBIT_ID, "KNC", date, KNC.getLowestAsk(), KNC.getHighestBid()));
        exchangeRates.add(new ExchangeRate(OXYBIT_ID, "FUN", date, FUN.getLowestAsk(), FUN.getHighestBid()));
        exchangeRates.add(new ExchangeRate(OXYBIT_ID, "SALT", date, SALT.getLowestAsk(), SALT.getHighestBid()));
        exchangeRates.add(new ExchangeRate(OXYBIT_ID, "BNT", date, BNT.getLowestAsk(), BNT.getHighestBid()));
        exchangeRates.add(new ExchangeRate(OXYBIT_ID, "REQ", date, REQ.getLowestAsk(), REQ.getHighestBid()));
        exchangeRates.add(new ExchangeRate(OXYBIT_ID, "SAN", date, SAN.getLowestAsk(), SAN.getHighestBid()));
        exchangeRates.add(new ExchangeRate(OXYBIT_ID, "GNO", date, GNO.getLowestAsk(), GNO.getHighestBid()));
        exchangeRates.add(new ExchangeRate(OXYBIT_ID, "ICN", date, ICN.getLowestAsk(), ICN.getHighestBid()));
        exchangeRates.add(new ExchangeRate(OXYBIT_ID, "POE", date, POE.getLowestAsk(), POE.getHighestBid()));
        exchangeRates.add(new ExchangeRate(OXYBIT_ID, "CVC", date, CVC.getLowestAsk(), CVC.getHighestBid()));
        exchangeRates.add(new ExchangeRate(OXYBIT_ID, "STORJ", date, STORJ.getLowestAsk(), STORJ.getHighestBid()));
        exchangeRates.add(new ExchangeRate(OXYBIT_ID, "MCO", date, MCO.getLowestAsk(), MCO.getHighestBid()));
        exchangeRates.add(new ExchangeRate(OXYBIT_ID, "ANT", date, ANT.getLowestAsk(), ANT.getHighestBid()));
        return exchangeRates;
    }


}
