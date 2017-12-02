package com.fr0ddy.coinin.ui.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.fr0ddy.coinin.R;
import com.fr0ddy.coinin.service.RateService;
import com.fr0ddy.coinin.ui.base.BaseActivity;
import com.fr0ddy.coinin.ui.home.HomeActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * Created by gaurav on 15/11/17.
 */

public class SplashActivity extends BaseActivity implements SplashContract.View {

    @Inject
    SplashContract.Presenter<SplashContract.View, SplashContract.Interactor> mPresenter;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, SplashActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RateService.start(this);

        setContentView(R.layout.activity_splash);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(SplashActivity.this);

        setUp();
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {
        mPresenter.initializeApp();
    }

    @Override
    public void openHomeActivity() {
        Intent intent = HomeActivity.getStartIntent(SplashActivity.this);
        startActivity(intent);
        finish();
    }
}
