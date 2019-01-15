package com.example.akshith.redditfeed.domain

import io.reactivex.Observable
import javax.inject.Inject

class RedditInteractor @Inject constructor(private val redditRepository: IRedditRepository) : IRedditInteractor {
    override fun getRedditData(): Observable<ArrayList<RedditEntity>> = redditRepository.getRedditData()
}