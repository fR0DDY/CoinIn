package com.fr0ddy.coinin.ui.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fr0ddy.coinin.R;
import com.fr0ddy.coinin.data.source.local.db.model.CurrentExchangeRate;
import com.fr0ddy.coinin.ui.base.BaseFragment;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gaurav on 05/12/17.
 */

public class CurrencyFragment extends BaseFragment implements CurrencyContract.View {

    @Inject
    CurrencyContract.Presenter<CurrencyContract.View, CurrencyContract.Interactor> mPresenter;

    @Inject
    LinearLayoutManager mLayoutManager;

    @Inject
    ExchangeRateAdapter mExchangeRateAdapter;

    String mCurrency;

    @BindView(R.id.exchange_rate_recycler_view)
    RecyclerView mRecyclerView;

    @Inject
    public CurrencyFragment() {
        // Requires empty public constructor
    }

    public static CurrencyFragment newInstance(String currency) {
        Bundle args = new Bundle();
        args.putString("currency", currency);
        CurrencyFragment fragment = new CurrencyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_currency, container, false);

        setUnBinder(ButterKnife.bind(this, view));

        mPresenter.onAttach(this);

        return view;
    }

    @Override
    protected void setUp(View view) {
        Bundle bundle = getArguments();
        mCurrency = bundle.getString("currency");
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mExchangeRateAdapter);
        mPresenter.getRates(mCurrency);
    }

    public String getCurrency() {
        return mCurrency;
    }

    @Override
    public void setRate(List<CurrentExchangeRate> exchangeRates) {
        mExchangeRateAdapter.clearItems();
        for (CurrentExchangeRate exchangeRate : exchangeRates) {
            mExchangeRateAdapter.addItems(exchangeRate);
        }
    }
}
