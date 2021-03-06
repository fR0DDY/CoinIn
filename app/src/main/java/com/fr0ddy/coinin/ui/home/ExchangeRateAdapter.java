package com.fr0ddy.coinin.ui.home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fr0ddy.coinin.R;
import com.fr0ddy.coinin.data.source.local.db.model.CurrentExchangeRate;
import com.fr0ddy.coinin.ui.base.BaseViewHolder;

import java.text.SimpleDateFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gaurav on 06/12/17.
 */

public class ExchangeRateAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private List<CurrentExchangeRate> mExchangeRateList;

    public ExchangeRateAdapter(List<CurrentExchangeRate> exchangeRateList) {
        mExchangeRateList = exchangeRateList;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                return new ViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_exchange_rate_view, parent, false));
            case VIEW_TYPE_EMPTY:
            default:
                return new EmptyViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemViewType(int position) {
        if (mExchangeRateList != null && mExchangeRateList.size() > 0) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }
    }

    @Override
    public int getItemCount() {
        if (mExchangeRateList != null && mExchangeRateList.size() > 0) {
            return mExchangeRateList.size();
        } else {
            return 1;
        }
    }

    public void addItems(CurrentExchangeRate show) {
        mExchangeRateList.add(show);
        notifyDataSetChanged();
    }

    public void clearItems() {
        mExchangeRateList.clear();
    }

    public class ViewHolder extends BaseViewHolder {

        @BindView(R.id.exchange_name)
        TextView exchangeName;

        @BindView(R.id.buy_rate)
        TextView buyRate;

        @BindView(R.id.sell_rate)
        TextView sellRate;

        @BindView(R.id.last_update_time)
        TextView lastUpdatedTime;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        protected void clear() {
            exchangeName.setText("");
            buyRate.setText("");
            sellRate.setText("");
            lastUpdatedTime.setText("");
        }

        public void onBind(int position) {
            super.onBind(position);

            final CurrentExchangeRate exchangeRate = mExchangeRateList.get(position);

            exchangeName.setText("" + exchangeRate.getExchangeName());
            if (exchangeRate.getBuyRate() > 1000.0) {
                buyRate.setText("₹" + Math.round(exchangeRate.getBuyRate()));
                sellRate.setText("₹" + Math.round(exchangeRate.getSellRate()));
            } else {
                buyRate.setText("₹" + (Math.round(exchangeRate.getBuyRate() * 100.0) / 100.0));
                sellRate.setText("₹" + (Math.round(exchangeRate.getSellRate() * 100.0) / 100.0));
            }
            lastUpdatedTime.setText(dateFormat.format(exchangeRate.getDateTime()));
        }
    }

    public class EmptyViewHolder extends BaseViewHolder {

        public EmptyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        protected void clear() {

        }
    }
}
