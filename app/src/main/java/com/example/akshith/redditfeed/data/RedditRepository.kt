package com.example.akshith.redditfeed.data

import com.example.akshith.redditfeed.domain.IRedditRepository
import com.example.akshith.redditfeed.domain.entities.RedditEntity
import io.reactivex.Observable
import javax.inject.Inject

class RedditRepository @Inject constructor(private val redditEntityMapper: RedditResponseMapper, private val redditService: RedditService) : IRedditRepository {

    override fun getRedditData(): Observable<ArrayList<RedditEntity>> = redditService.getRedditData()
            .map { t: Reddit -> redditEntityMapper.getRedditEntity(t) }
}