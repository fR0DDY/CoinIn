package com.fr0ddy.coinin.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by gaurav on 26/11/17.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ServiceScoped {
}
