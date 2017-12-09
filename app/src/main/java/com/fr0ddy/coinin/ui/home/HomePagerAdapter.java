package com.fr0ddy.coinin.ui.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by gaurav on 05/12/17.
 */

public class HomePagerAdapter extends FragmentStatePagerAdapter {

    private int mTabCount;

    public HomePagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.mTabCount = 0;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return CurrencyFragment.newInstance("BTC");
            case 1:
                return CurrencyFragment.newInstance("ETH");
            case 2:
                return CurrencyFragment.newInstance("BCH");
            case 3:
                return CurrencyFragment.newInstance("XRP");
            case 4:
                return CurrencyFragment.newInstance("LTC");
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mTabCount;
    }

    public void setCount(int count) {
        mTabCount = count;
    }

}
