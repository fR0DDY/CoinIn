package com.fr0ddy.coinin.ui.home;

import com.fr0ddy.coinin.data.source.local.db.model.ExchangeRate;
import com.fr0ddy.coinin.ui.base.BaseInteractorContract;
import com.fr0ddy.coinin.ui.base.BasePresenterContract;
import com.fr0ddy.coinin.ui.base.BaseViewContract;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by gaurav on 05/12/17.
 */

public class CurrencyContract {

    interface View extends BaseViewContract {
        void setRate(List<ExchangeRate> exchangeRates);
    }

    interface Interactor extends BaseInteractorContract {
        Flowable<List<ExchangeRate>> getRatesForCurrency(String currency);
    }

    interface Presenter<V extends View,
            I extends Interactor> extends BasePresenterContract<V, I> {
        void getRates(String currency);
    }
}
