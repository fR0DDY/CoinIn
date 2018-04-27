package com.fr0ddy.coinin.data.source.remote.model;

import com.fr0ddy.coinin.data.source.local.db.model.ExchangeRate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.fr0ddy.coinin.utils.AppConstants.MINTOPAY_ID;
import static com.fr0ddy.coinin.utils.AppConstants.OXYBIT_ID;

/**
 * Created by gaurav on 23/04/18.
 */

public class MintoPayResponse {
    String aby;
    String adx;
    String amp;
    String bat;
    String bitb;
    String dgb;
    String doge;
    String emc2;
    String etc;
    String gnt;
    String kmd;
    String mco;
    String music;
    String nxt;
    String pot;
    String rby;
    String rdd;
    String sc;
    String snt;
    String steem;
    String sys;
    String thc;
    String vtc;
    String xdn;
    String xem;
    String xlm;
    String xmy;
    String xrp;
    String xvg;
    String ada;
    String btg;
    String eng;
    String mana;
    String powr;
    String salt;
    String vib;

    public List<ExchangeRate> getExchangeRates(Date date) {
        List<ExchangeRate> exchangeRates = new ArrayList<>();
        exchangeRates.add(new ExchangeRate(MINTOPAY_ID, "ABY", date, Double.parseDouble(aby.split(",")[0]), Double.parseDouble(aby.split(",")[1])));
        exchangeRates.add(new ExchangeRate(MINTOPAY_ID, "ADX", date, Double.parseDouble(adx.split(",")[0]), Double.parseDouble(adx.split(",")[1])));
        exchangeRates.add(new ExchangeRate(MINTOPAY_ID, "AMP", date, Double.parseDouble(amp.split(",")[0]), Double.parseDouble(amp.split(",")[1])));
        exchangeRates.add(new ExchangeRate(MINTOPAY_ID, "BAT", date, Double.parseDouble(bat.split(",")[0]), Double.parseDouble(bat.split(",")[1])));
        exchangeRates.add(new ExchangeRate(MINTOPAY_ID, "BITB", date, Double.parseDouble(bitb.split(",")[0]), Double.parseDouble(bitb.split(",")[1])));
        exchangeRates.add(new ExchangeRate(MINTOPAY_ID, "DGB", date, Double.parseDouble(dgb.split(",")[0]), Double.parseDouble(dgb.split(",")[1])));
        exchangeRates.add(new ExchangeRate(MINTOPAY_ID, "DOGE", date, Double.parseDouble(doge.split(",")[0]), Double.parseDouble(doge.split(",")[1])));
        exchangeRates.add(new ExchangeRate(MINTOPAY_ID, "EMC2", date, Double.parseDouble(emc2.split(",")[0]), Double.parseDouble(emc2.split(",")[1])));
        exchangeRates.add(new ExchangeRate(MINTOPAY_ID, "GNT", date, Double.parseDouble(gnt.split(",")[0]), Double.parseDouble(gnt.split(",")[1])));
        exchangeRates.add(new ExchangeRate(MINTOPAY_ID, "ETC", date, Double.parseDouble(etc.split(",")[0]), Double.parseDouble(etc.split(",")[1])));
        exchangeRates.add(new ExchangeRate(MINTOPAY_ID, "KMC", date, Double.parseDouble(kmd.split(",")[0]), Double.parseDouble(kmd.split(",")[1])));
        exchangeRates.add(new ExchangeRate(MINTOPAY_ID, "MCO", date, Double.parseDouble(mco.split(",")[0]), Double.parseDouble(mco.split(",")[1])));
        exchangeRates.add(new ExchangeRate(MINTOPAY_ID, "MUSIC", date, Double.parseDouble(music.split(",")[0]), Double.parseDouble(music.split(",")[1])));
        exchangeRates.add(new ExchangeRate(MINTOPAY_ID, "NXT", date, Double.parseDouble(nxt.split(",")[0]), Double.parseDouble(nxt.split(",")[1])));
        exchangeRates.add(new ExchangeRate(MINTOPAY_ID, "POT", date, Double.parseDouble(pot.split(",")[0]), Double.parseDouble(pot.split(",")[1])));
        exchangeRates.add(new ExchangeRate(MINTOPAY_ID, "RBY", date, Double.parseDouble(rby.split(",")[0]), Double.parseDouble(rby.split(",")[1])));
        exchangeRates.add(new ExchangeRate(MINTOPAY_ID, "RDD", date, Double.parseDouble(rdd.split(",")[0]), Double.parseDouble(rdd.split(",")[1])));
        exchangeRates.add(new ExchangeRate(MINTOPAY_ID, "SC", date, Double.parseDouble(sc.split(",")[0]), Double.parseDouble(sc.split(",")[1])));
        exchangeRates.add(new ExchangeRate(MINTOPAY_ID, "SNT", date, Double.parseDouble(snt.split(",")[0]), Double.parseDouble(snt.split(",")[1])));
        exchangeRates.add(new ExchangeRate(MINTOPAY_ID, "STEEM", date, Double.parseDouble(steem.split(",")[0]), Double.parseDouble(steem.split(",")[1])));
        exchangeRates.add(new ExchangeRate(MINTOPAY_ID, "SYS", date, Double.parseDouble(sys.split(",")[0]), Double.parseDouble(sys.split(",")[1])));
        exchangeRates.add(new ExchangeRate(MINTOPAY_ID, "THC", date, Double.parseDouble(thc.split(",")[0]), Double.parseDouble(thc.split(",")[1])));
        exchangeRates.add(new ExchangeRate(MINTOPAY_ID, "VTC", date, Double.parseDouble(vtc.split(",")[0]), Double.parseDouble(vtc.split(",")[1])));
        exchangeRates.add(new ExchangeRate(MINTOPAY_ID, "XDN", date, Double.parseDouble(xdn.split(",")[0]), Double.parseDouble(xdn.split(",")[1])));
        exchangeRates.add(new ExchangeRate(MINTOPAY_ID, "XEM", date, Double.parseDouble(xem.split(",")[0]), Double.parseDouble(xem.split(",")[1])));
        exchangeRates.add(new ExchangeRate(MINTOPAY_ID, "XLM", date, Double.parseDouble(xlm.split(",")[0]), Double.parseDouble(xlm.split(",")[1])));
        exchangeRates.add(new ExchangeRate(MINTOPAY_ID, "XMY", date, Double.parseDouble(xmy.split(",")[0]), Double.parseDouble(xmy.split(",")[1])));
        exchangeRates.add(new ExchangeRate(MINTOPAY_ID, "XRP", date, Double.parseDouble(xrp.split(",")[0]), Double.parseDouble(xrp.split(",")[1])));
        exchangeRates.add(new ExchangeRate(MINTOPAY_ID, "XVG", date, Double.parseDouble(xvg.split(",")[0]), Double.parseDouble(xvg.split(",")[1])));
        exchangeRates.add(new ExchangeRate(MINTOPAY_ID, "ADA", date, Double.parseDouble(ada.split(",")[0]), Double.parseDouble(ada.split(",")[1])));
        exchangeRates.add(new ExchangeRate(MINTOPAY_ID, "BTG", date, Double.parseDouble(btg.split(",")[0]), Double.parseDouble(btg.split(",")[1])));
        exchangeRates.add(new ExchangeRate(MINTOPAY_ID, "ENG", date, Double.parseDouble(eng.split(",")[0]), Double.parseDouble(eng.split(",")[1])));
        exchangeRates.add(new ExchangeRate(MINTOPAY_ID, "MANA", date, Double.parseDouble(mana.split(",")[0]), Double.parseDouble(mana.split(",")[1])));
        exchangeRates.add(new ExchangeRate(MINTOPAY_ID, "POWR", date, Double.parseDouble(powr.split(",")[0]), Double.parseDouble(powr.split(",")[1])));
        exchangeRates.add(new ExchangeRate(MINTOPAY_ID, "SALT", date, Double.parseDouble(salt.split(",")[0]), Double.parseDouble(salt.split(",")[1])));
        exchangeRates.add(new ExchangeRate(MINTOPAY_ID, "VIB", date, Double.parseDouble(vib.split(",")[0]), Double.parseDouble(vib.split(",")[1])));


        return exchangeRates;
    }
}
