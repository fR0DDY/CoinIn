package com.fr0ddy.coinin.utils.rx;

import io.reactivex.Scheduler;

/**
 * Created by gaurav on 15/06/17.
 */

public interface SchedulerProvider {

    Scheduler ui();

    Scheduler computation();

    Scheduler io();

}
