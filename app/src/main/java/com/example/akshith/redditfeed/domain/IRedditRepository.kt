package com.example.akshith.redditfeed.domain

import io.reactivex.Observable

interface IRedditRepository {
    fun getRedditData(): Observable<ArrayList<RedditEntity>>
}