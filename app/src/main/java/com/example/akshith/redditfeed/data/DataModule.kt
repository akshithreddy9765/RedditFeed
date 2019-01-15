package com.example.akshith.redditfeed.data

import com.example.akshith.redditfeed.domain.IRedditRepository
import com.google.gson.Gson
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module(includes = [DataModule.RepositoryModule::class])
class DataModule {

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor.Level = HttpLoggingInterceptor.Level.BODY

    @Singleton
    @Provides
    fun provideGson(): Gson = Gson()

    @Singleton
    @Provides
    fun provideRedditService(serviceFactory: ServiceFactory) = serviceFactory.createService(RedditService::class.java)

    @Module
    abstract inner class RepositoryModule {
        @Binds
        abstract fun provideRedditRepository(redditRepository: RedditRepository): IRedditRepository

    }
}