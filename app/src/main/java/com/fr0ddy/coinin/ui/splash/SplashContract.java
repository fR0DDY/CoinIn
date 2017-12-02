package com.fr0ddy.coinin.ui.splash;

import com.fr0ddy.coinin.ui.base.BaseInteractorContract;
import com.fr0ddy.coinin.ui.base.BasePresenterContract;
import com.fr0ddy.coinin.ui.base.BaseViewContract;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by gaurav on 15/11/17.
 */

public interface SplashContract {

    interface View extends BaseViewContract {
        void openHomeActivity();
    }

    interface Interactor extends BaseInteractorContract {
        Observable<List<Long>> saveDefaultExchanges();
        Observable<List<Long>> saveDefaultExchangeFees();
    }

    interface Presenter<V extends View,
            I extends Interactor> extends BasePresenterContract<V, I> {
        void initializeApp();
    }
}
