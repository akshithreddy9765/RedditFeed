package com.example.akshith.redditfeed

import com.example.akshith.redditfeed.data.DataModule
import com.example.akshith.redditfeed.domain.DomainModule
import com.example.akshith.redditfeed.ui.AppModule
import com.example.akshith.redditfeed.ui.RedditActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, DomainModule::class, DataModule::class])
interface AppComponent {
    fun inject(redditActivity: RedditActivity)
}