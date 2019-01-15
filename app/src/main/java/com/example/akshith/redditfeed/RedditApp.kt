package com.example.akshith.redditfeed

import android.app.Application
import com.example.akshith.redditfeed.data.DataModule
import com.example.akshith.redditfeed.domain.DomainModule
import com.example.akshith.redditfeed.ui.AppModule

class RedditApp : Application() {
    companion object {
        private var component: AppComponent? = null
        fun getComponent(): AppComponent? {
            return component
        }
    }

    override fun onCreate() {
        super.onCreate()
        if (component == null) {
            buildAppComponent()
        }
    }

    private fun buildAppComponent() {
        component = DaggerAppComponent.builder().build()
    }
}