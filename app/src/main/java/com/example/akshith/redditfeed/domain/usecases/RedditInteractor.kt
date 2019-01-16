package com.example.akshith.redditfeed.domain.usecases

import com.example.akshith.redditfeed.domain.IRedditInteractor
import com.example.akshith.redditfeed.domain.IRedditRepository
import com.example.akshith.redditfeed.domain.entities.RedditEntity
import io.reactivex.Observable
import javax.inject.Inject

class RedditInteractor @Inject constructor(private val redditRepository: IRedditRepository) : IRedditInteractor {
    override fun getRedditData(): Observable<ArrayList<RedditEntity>> = redditRepository.getRedditData()
}