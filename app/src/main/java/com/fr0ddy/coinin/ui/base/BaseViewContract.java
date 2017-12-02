package com.fr0ddy.coinin.ui.base;

import android.support.annotation.StringRes;

/**
 * Created by gaurav on 17/11/17.
 */

public interface BaseViewContract {
    void showLoading();

    void hideLoading();

    void onError(@StringRes int resId);

    void onError(String message);

    void showMessage(String message);

    void showMessage(@StringRes int resId);

    boolean isNetworkConnected();

    void hideKeyboard();
}
