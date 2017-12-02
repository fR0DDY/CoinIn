package com.fr0ddy.coinin.ui.splash;

import com.fr0ddy.coinin.R;
import com.fr0ddy.coinin.ui.base.BasePresenter;
import com.fr0ddy.coinin.utils.rx.SchedulerProvider;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import timber.log.Timber;

/**
 * Created by gaurav on 18/11/17.
 */

public class SplashPresenter<V extends SplashContract.View, I extends SplashContract.Interactor>
        extends BasePresenter<V, I> implements SplashContract.Presenter<V, I> {

    @Inject
    public SplashPresenter(I mvpInteractor,
                           SchedulerProvider schedulerProvider) {
        super(mvpInteractor, schedulerProvider);
    }

    @Override
    public void onAttach(V view) {
        super.onAttach(view);
    }

    @Override
    public void initializeApp() {
        getCompositeDisposable().add(Observable.zip(getInteractor()
                .saveDefaultExchanges(), getInteractor().saveDefaultExchangeFees(), (exchanges, fees) -> exchanges)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(longs -> {
                    if (!isViewAttached()) {
                        return;
                    }
                    getView().openHomeActivity();
                }, throwable -> {
                    if (!isViewAttached()) {
                        return;
                    }
                    Timber.e(throwable);
                    getView().onError(R.string.some_error);
                }));
    }
}
