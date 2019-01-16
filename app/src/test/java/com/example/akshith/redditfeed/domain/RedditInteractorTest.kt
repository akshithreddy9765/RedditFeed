package com.example.akshith.redditfeed.domain

import com.example.akshith.redditfeed.domain.entities.RedditEntity
import com.example.akshith.redditfeed.domain.usecases.RedditInteractor
import io.reactivex.Observable
import org.amshove.kluent.*
import org.junit.Before
import org.junit.Test
import java.lang.RuntimeException

class RedditInteractorTest {
    val redditRepository = mock<IRedditRepository>()
    lateinit var subject: RedditInteractor

    @Before
    fun setUp() {
        subject = RedditInteractor(redditRepository)
    }

    @Test
    fun test_when_calling_getRedditData_it_should_invoke_RedditRepository() {
        When calling redditRepository.getRedditData() `it returns` Observable.fromArray(arrayListOf(RedditEntity("title", "selfstring", 3, "author")))
        subject.getRedditData().test()
                .assertComplete()
                .assertNoErrors()
                .assertValue { it.size == 1 }

        Verify on redditRepository that redditRepository.getRedditData() was called
    }

    @Test
    fun test_when_calling_getRedditData_when_redditRepository_getRedditData_returns_error_it_should_throw_an_error() {
        When calling redditRepository.getRedditData() `it returns` Observable.error(RuntimeException())
        subject.getRedditData().test()
                .assertNotComplete()
                .assertNoValues()
                .assertError(RuntimeException::class.java)
        Verify on redditRepository that redditRepository.getRedditData() was called
    }
}