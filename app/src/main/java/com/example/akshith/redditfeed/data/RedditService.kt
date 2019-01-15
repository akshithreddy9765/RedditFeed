package com.example.akshith.redditfeed.data

import io.reactivex.Observable
import retrofit2.http.GET

interface RedditService {
    @GET("/r/androiddev.json")
    fun getRedditData(): Observable<Reddit>
}