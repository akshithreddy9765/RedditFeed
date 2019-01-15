package com.example.akshith.redditfeed.data

import com.example.akshith.redditfeed.domain.RedditEntity
import io.reactivex.Observable
import org.amshove.kluent.*
import org.junit.Before
import org.junit.Test
import java.lang.RuntimeException

class RedditRepositoryTest {
    val redditService = mock<RedditService>()
    val redditResponseMapper = mock<RedditResponseMapper>()
    lateinit var subject: RedditRepository

    @Before
    fun setUp() {
        subject = RedditRepository(redditResponseMapper, redditService);
    }

    @Test
    fun test_when_calling_getRedditData_when_reddiService_getRedditData_returns_success_response_then_it_should_invoke_redditResponseMapper() {
        When calling redditService.getRedditData() `it returns` Observable.fromCallable { Reddit().apply { kind = "kind1"; data = RedditData() } }
        When calling redditResponseMapper.getRedditEntity(any()) `it returns` getRedditData()
        subject.getRedditData().test()
                .assertComplete()
                .assertNoErrors()
                .assertValue { it.size == 1 }

        Verify on redditService that redditService.getRedditData() was called
        Verify on redditResponseMapper that redditResponseMapper.getRedditEntity(org.amshove.kluent.any()) was called
    }

    @Test
    fun test_when_calling_getRedditData_when_redditService_returns_error_then_it_should_not_invoke_redditResponseMapper() {
        When calling redditService.getRedditData() `it returns` Observable.error(RuntimeException())
        subject.getRedditData().test()
                .assertNotComplete()
                .assertNoValues()
                .assertError(RuntimeException::class.java)
        Verify on redditService that redditService.getRedditData() was called
        VerifyNotCalled on redditResponseMapper that redditResponseMapper.getRedditEntity(org.amshove.kluent.any())
    }

    private fun getRedditData(): ArrayList<RedditEntity> {
        return arrayListOf<RedditEntity>().apply {
            add(RedditEntity("title1", "selftext1", 3, "author1"))
        }
    }
}