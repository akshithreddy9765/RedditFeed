package com.example.akshith.redditfeed.ui

import com.example.akshith.redditfeed.RxSchedulers
import com.example.akshith.redditfeed.domain.usecases.RedditInteractor
import com.example.akshith.redditfeed.presentation.RedditContract
import com.example.akshith.redditfeed.presentation.RedditPresenter
import com.example.akshith.redditfeed.presentation.RedditViewModelMapper
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.amshove.kluent.*
import org.amshove.kluent.any
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class RedditPresenterTest {
    val redditInteractor = mock(RedditInteractor::class.java)
    val redditViewModelMapper = mock(RedditViewModelMapper::class.java)
    val redditView = mock(RedditContract.RedditView::class.java)
    val rxSchedulers = RxSchedulers(Schedulers.trampoline(), Schedulers.trampoline())
    lateinit var subject: RedditPresenter

    @Before
    fun setUp() {
        subject = RedditPresenter(redditInteractor, redditViewModelMapper, rxSchedulers)
    }

    @Test
    fun test_when_calling_onAttachView_it_should_set_the_view_and_invoke_views_init_method() {
        subject.onAttachView(redditView)
        Assert.assertEquals(redditView, subject.redditView)
        verify(redditView).initViews()
    }

    @Test
    fun test_when_calling_fetchRedditData_when_reddit_interactor_return_success_response_then_it_should_call_view_setData() {
        When calling redditInteractor.getRedditData() `it returns` Observable.fromArray(arrayListOf())
        When calling redditViewModelMapper.getRedditViewModelList(any()) `it returns` arrayListOf()

        subject.onAttachView(redditView)
        subject.fetchRedditData()

        Verify on redditInteractor that redditInteractor.getRedditData() was called
        Verify on redditViewModelMapper that redditViewModelMapper.getRedditViewModelList(any()) was called
        Verify on redditView that redditView.showProgress() was called
        Verify on redditView that redditView.hideProgress() was called
        Verify on redditView that redditView.setData(any()) was called
        VerifyNotCalled on redditView that redditView.handleRedditError()
    }

    @Test
    fun test_when_calling_fetchRedditData_when_reddit_interactors_getRedditData_return_error_then_it_not_call_set_Data_and_handle_the_error() {
        When calling redditInteractor.getRedditData() `it returns` Observable.error(RuntimeException())

        subject.onAttachView(redditView)
        subject.fetchRedditData()

        Verify on redditInteractor that redditInteractor.getRedditData() was called
        VerifyNotCalled on redditViewModelMapper that redditViewModelMapper.getRedditViewModelList(any())
        Verify on redditView that redditView.showProgress() was called
        Verify on redditView that redditView.hideProgress() was called
        VerifyNotCalled on redditView that redditView.setData(any()) was called
        Verify on redditView that redditView.handleRedditError() was called
    }

    @Test
    fun test_when_calling_onRedditRowItemClicked_then_it_should_invoke_view_showSelfText() {
        val selfText = "selftext"
        subject.onAttachView(redditView)
        subject.onRedditRowItemClicked(selfText)
        Verify on redditView that redditView.showSelfText(selfText) was called
    }

    @Test
    fun test_when_calling_onDestroyView_it_should_destory_view() {
        subject.onAttachView(redditView)
        subject.onDestroyView()
        Assert.assertNull(subject.redditView)
    }
}