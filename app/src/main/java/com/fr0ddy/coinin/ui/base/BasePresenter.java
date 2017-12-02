package com.fr0ddy.coinin.ui.base;

import com.fr0ddy.coinin.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by gaurav on 15/11/17.
 */

public class BasePresenter<V extends BaseViewContract, I extends BaseInteractorContract>
        implements BasePresenterContract<V, I> {
    private final SchedulerProvider mSchedulerProvider;
    private final CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    private V mView;
    private I mInteractor;

    @Inject
    public BasePresenter(I baseInteractor,
                         SchedulerProvider schedulerProvider) {
        mInteractor = baseInteractor;
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void onAttach(V view) {
        mView = view;
    }

    @Override
    public void onDetach() {
        mCompositeDisposable.dispose();
        mView = null;
        mInteractor = null;
    }

    @Override
    public V getView() {
        return mView;
    }

    @Override
    public I getInteractor() {
        return mInteractor;
    }

    @Override
    public boolean isViewAttached() {
        return mView != null;
    }

    public SchedulerProvider getSchedulerProvider() {
        return mSchedulerProvider;
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }
}
