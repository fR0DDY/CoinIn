package com.fr0ddy.coinin.ui.home;

import com.fr0ddy.coinin.R;
import com.fr0ddy.coinin.data.repository.ExchangeRateRepository;
import com.fr0ddy.coinin.di.ActivityScoped;
import com.fr0ddy.coinin.ui.base.BasePresenter;
import com.fr0ddy.coinin.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * Created by gaurav on 15/11/17.
 */

@ActivityScoped
final class HomePresenter<V extends HomeContract.View, I extends HomeContract.Interactor>
        extends BasePresenter<V, I> implements HomeContract.Presenter<V, I> {

    private final ExchangeRateRepository mExchangeRateRepository;

    @Inject
    public HomePresenter(I interactor,
                         SchedulerProvider schedulerProvider, ExchangeRateRepository exchangeRateRepository) {
        super(interactor, schedulerProvider);
        this.mExchangeRateRepository = exchangeRateRepository;
    }

    @Override
    public void onViewPrepared() {
        getCompositeDisposable().add(getInteractor().getRates()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(exchangeRates -> {
                    if (!isViewAttached()) {
                        return;
                    }
                    getView().setRate(exchangeRates);
                }, throwable -> {
                    if (!isViewAttached()) {
                        return;
                    }
                    Timber.e(throwable);
                    getView().onError(R.string.some_error);
                }));
    }
}
