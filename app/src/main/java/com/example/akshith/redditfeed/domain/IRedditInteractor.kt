package com.example.akshith.redditfeed.domain

import com.example.akshith.redditfeed.domain.entities.RedditEntity
import io.reactivex.Observable

interface IRedditInteractor {
    fun getRedditData(): Observable<ArrayList<RedditEntity>>
}