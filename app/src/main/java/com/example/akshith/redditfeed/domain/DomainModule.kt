package com.example.akshith.redditfeed.domain

import com.example.akshith.redditfeed.domain.usecases.RedditInteractor
import dagger.Binds
import dagger.Module

@Module(includes = [DomainModule.InteractorModule::class])
class DomainModule {

    @Module
    abstract inner class InteractorModule {
        @Binds
        abstract fun provideRedditInteractor(redditInteractor: RedditInteractor): IRedditInteractor
    }
}