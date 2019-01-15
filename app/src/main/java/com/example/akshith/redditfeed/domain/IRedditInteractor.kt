package com.example.akshith.redditfeed.domain

import io.reactivex.Observable

interface IRedditInteractor {
    fun getRedditData(): Observable<ArrayList<RedditEntity>>
}