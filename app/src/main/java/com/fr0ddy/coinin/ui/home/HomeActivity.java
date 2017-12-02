package com.fr0ddy.coinin.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.fr0ddy.coinin.R;
import com.fr0ddy.coinin.data.source.local.db.model.ExchangeRate;
import com.fr0ddy.coinin.ui.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * Created by gaurav on 15/11/17.
 */

public class HomeActivity extends BaseActivity implements HomeContract.View {

    @Inject
    HomeContract.Presenter<HomeContract.View, HomeContract.Interactor> mPresenter;

    @BindView(R.id.rate)
    TextView rateView;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, HomeActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(HomeActivity.this);

        setUp();
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {
        mPresenter.onViewPrepared();
    }

    @Override
    public void setRate(List<ExchangeRate> exchangeRates) {
        Timber.d(exchangeRates.toString());
        if (exchangeRates != null && exchangeRates.size() > 0) {
            rateView.setText(exchangeRates.get(0).toString());
        }
    }
}
