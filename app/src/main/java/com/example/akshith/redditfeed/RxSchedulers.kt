package com.example.akshith.redditfeed

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RxSchedulers (var observeOnScheduler: Scheduler, var subscribeOnScheduler: Scheduler)