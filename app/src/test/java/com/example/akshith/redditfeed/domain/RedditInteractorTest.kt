package com.example.akshith.redditfeed.domain

import com.example.akshith.redditfeed.data.RedditRepository
import org.amshove.kluent.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class RedditInteractorTest {
    val redditRepository = mock<IRedditRepository>()
    lateinit var subject: RedditInteractor

    @Before
    fun setUp() {
        subject = RedditInteractor(redditRepository)
    }

    @Test
    fun test_when_calling_getRedditData_it_should_invoke_RedditRepository() {
        subject.getRedditData()
        Verify on redditRepository that redditRepository.getRedditData() was called
    }
}