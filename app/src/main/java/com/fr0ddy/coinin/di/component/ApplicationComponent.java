package com.fr0ddy.coinin.di.component;

import android.app.Application;

import com.fr0ddy.coinin.CoinInApp;
import com.fr0ddy.coinin.data.repository.ExchangeRateRepository;
import com.fr0ddy.coinin.data.repository.ExchangeRepository;
import com.fr0ddy.coinin.data.source.local.db.DatabaseModule;
import com.fr0ddy.coinin.di.module.ActivityBindingModule;
import com.fr0ddy.coinin.di.module.ApiServiceModule;
import com.fr0ddy.coinin.di.module.ApplicationModule;
import com.fr0ddy.coinin.di.module.DataModule;
import com.fr0ddy.coinin.utils.rx.SchedulerProvider;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by gaurav on 12/06/17.
 */

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, ApplicationModule.class, ActivityBindingModule.class, DatabaseModule.class, DataModule.class, ApiServiceModule.class})
public interface ApplicationComponent extends AndroidInjector<CoinInApp> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        ApplicationComponent build();

    }

    ExchangeRepository getExchangeRepository();

    ExchangeRateRepository getExchangeRateRepository();

    SchedulerProvider getSchedulerProvider();
}
