package com.example.akshith.redditfeed.ui

import com.example.akshith.redditfeed.RxSchedulers
import com.example.akshith.redditfeed.domain.RedditInteractor
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class RedditPresenter @Inject constructor(private val redditInteractor: RedditInteractor, private val redditViewModelMapper: RedditViewModelMapper, private val rxSchedulers: RxSchedulers) : RedditContract.IRedditPresenter {


    var redditView: RedditContract.RedditView? = null
    private val disposable: CompositeDisposable = CompositeDisposable()

    override fun onAttachView(redditView: RedditContract.RedditView) {
        this.redditView = redditView
        redditView.initViews()
    }

    override fun fetchRedditData() {
        disposable.add(redditInteractor.getRedditData()
                .map { redditViewModelMapper.getRedditViewModelList(it) }
                .observeOn(rxSchedulers.observeOnScheduler)
                .subscribeOn(rxSchedulers.subscribeOnScheduler)
                .doOnSubscribe { redditView?.showProgress() }
                .doOnTerminate { redditView?.hideProgress() }
                .subscribe(
                        { redditView?.setData(it) },
                        { redditView?.handleRedditError() }
                )
        )
    }

    override fun onDestroyView() {
        if (!disposable.isDisposed) disposable.dispose()
        redditView = null
    }
}