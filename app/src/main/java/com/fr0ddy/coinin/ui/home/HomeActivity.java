package com.fr0ddy.coinin.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.fr0ddy.coinin.R;
import com.fr0ddy.coinin.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gaurav on 15/11/17.
 */

public class HomeActivity extends BaseActivity {

    @Inject
    HomePagerAdapter mPagerAdapter;

    @BindView(R.id.home_view_pager)
    ViewPager mViewPager;

    @BindView(R.id.home_tab_layout)
    TabLayout mTabLayout;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, HomeActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setUnBinder(ButterKnife.bind(this));

        setUp();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void setUp() {
        mPagerAdapter.setCount(5);

        mViewPager.setAdapter(mPagerAdapter);

        mTabLayout.addTab(mTabLayout.newTab().setText("BTC"));
        mTabLayout.addTab(mTabLayout.newTab().setText("ETH"));
        mTabLayout.addTab(mTabLayout.newTab().setText("BCH"));
        mTabLayout.addTab(mTabLayout.newTab().setText("XRP"));
        mTabLayout.addTab(mTabLayout.newTab().setText("LTC"));

        mTabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
    }
}
