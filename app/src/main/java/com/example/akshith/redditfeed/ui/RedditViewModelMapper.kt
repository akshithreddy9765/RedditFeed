package com.example.akshith.redditfeed.ui

import com.example.akshith.redditfeed.domain.RedditEntity
import javax.inject.Inject

class RedditViewModelMapper @Inject constructor() {
    fun getRedditViewModelList(redditEntityList: ArrayList<RedditEntity>): ArrayList<RedditViewModel> {
        val redditViewModelList: ArrayList<RedditViewModel> = arrayListOf()
        redditEntityList.forEach {
            redditViewModelList.add(RedditViewModel(it.title, it.selfText, "Comments:${it.numberOfComments}", "Author:${it.authorName}"))
        }
        return redditViewModelList
    }
}