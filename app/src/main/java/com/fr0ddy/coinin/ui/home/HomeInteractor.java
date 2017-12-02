package com.fr0ddy.coinin.ui.home;

import com.fr0ddy.coinin.data.repository.ExchangeRateRepository;
import com.fr0ddy.coinin.data.source.local.db.model.ExchangeRate;
import com.fr0ddy.coinin.data.source.local.prefs.PreferencesHelper;
import com.fr0ddy.coinin.ui.base.BaseInteractor;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by gaurav on 18/11/17.
 */

public class HomeInteractor extends BaseInteractor
        implements HomeContract.Interactor {

    private ExchangeRateRepository mExchangeRateRepository;

    @Inject
    public HomeInteractor(PreferencesHelper preferencesHelper, ExchangeRateRepository exchangeRateRepository) {
        super(preferencesHelper);
        mExchangeRateRepository = exchangeRateRepository;
    }

    @Override
    public Flowable<List<ExchangeRate>> getRates() {
        return mExchangeRateRepository.getRates();
    }
}
