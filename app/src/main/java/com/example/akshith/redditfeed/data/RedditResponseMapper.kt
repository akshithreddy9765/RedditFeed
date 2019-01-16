package com.example.akshith.redditfeed.data

import com.example.akshith.redditfeed.domain.entities.RedditEntity
import javax.inject.Inject

class RedditResponseMapper @Inject constructor() {

    fun getRedditEntity(reddit: Reddit): ArrayList<RedditEntity> {
        val redditEntityList = ArrayList<RedditEntity>()
        reddit.data.children.forEach { redditChildren: RedditChildren ->
            redditChildren.data.let {
                redditEntityList.add(RedditEntity(it.title, it.selftext, it.num_comments, it.author_fullname))
            }
        }
        return redditEntityList
    }
}