package com.fr0ddy.coinin.di.component;

import com.fr0ddy.coinin.di.ServiceScoped;
import com.fr0ddy.coinin.di.module.ServiceModule;
import com.fr0ddy.coinin.service.RateService;

import dagger.Component;

/**
 * Created by gaurav on 21/11/17.
 */

@ServiceScoped
@Component(dependencies = ApplicationComponent.class, modules = {ServiceModule.class})
public interface ServiceComponent {

    void inject(RateService service);

}
