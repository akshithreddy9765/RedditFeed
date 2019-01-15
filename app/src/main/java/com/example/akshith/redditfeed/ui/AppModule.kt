package com.example.akshith.redditfeed.ui

import com.example.akshith.redditfeed.RxSchedulers
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@Module(includes = [AppModule.PresenterModule::class])
class AppModule {

    @Provides
    fun provideRxSceduler(): RxSchedulers = RxSchedulers(AndroidSchedulers.mainThread(), Schedulers.newThread())

    @Module
    abstract inner class PresenterModule {
        @Binds
        abstract fun provideRedditPresenter(redditPresenter: RedditPresenter): RedditContract.IRedditPresenter
    }
}