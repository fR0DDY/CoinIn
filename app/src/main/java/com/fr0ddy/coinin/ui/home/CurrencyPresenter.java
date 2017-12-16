package com.fr0ddy.coinin.ui.home;

import com.fr0ddy.coinin.R;
import com.fr0ddy.coinin.di.FragmentScoped;
import com.fr0ddy.coinin.ui.base.BasePresenter;
import com.fr0ddy.coinin.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
import timber.log.Timber;

/**
 * Created by gaurav on 05/12/17.
 */

@FragmentScoped
final class CurrencyPresenter<V extends CurrencyContract.View, I extends CurrencyContract.Interactor>
        extends BasePresenter<V, I> implements CurrencyContract.Presenter<V, I> {

    @Inject
    public CurrencyPresenter(I interactor,
                             SchedulerProvider schedulerProvider) {
        super(interactor, schedulerProvider);
    }

    @Override
    public void getRates(String currency) {
        getCompositeDisposable().add(getInteractor().getRatesForCurrency(currency)
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
