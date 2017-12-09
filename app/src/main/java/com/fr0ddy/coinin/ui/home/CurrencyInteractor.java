package com.fr0ddy.coinin.ui.home;

import com.fr0ddy.coinin.data.repository.ExchangeRateRepository;
import com.fr0ddy.coinin.data.source.local.db.model.ExchangeRate;
import com.fr0ddy.coinin.data.source.local.prefs.PreferencesHelper;
import com.fr0ddy.coinin.ui.base.BaseInteractor;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by gaurav on 05/12/17.
 */

public class CurrencyInteractor extends BaseInteractor
        implements CurrencyContract.Interactor {

    private ExchangeRateRepository mExchangeRateRepository;

    @Inject
    public CurrencyInteractor(PreferencesHelper preferencesHelper, ExchangeRateRepository exchangeRateRepository) {
        super(preferencesHelper);
        mExchangeRateRepository = exchangeRateRepository;
    }

    @Override
    public Flowable<List<ExchangeRate>> getRatesForCurrency(String currency) {
        return mExchangeRateRepository.getRatesForCurrency(currency);
    }
}
