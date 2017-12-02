package com.fr0ddy.coinin.ui.base;

/**
 * Created by gaurav on 15/11/17.
 */

public interface BasePresenterContract<V extends BaseViewContract, I extends BaseInteractorContract> {

    void onAttach(V mvpView);

    void onDetach();

    V getView();

    I getInteractor();

    boolean isViewAttached();
}
