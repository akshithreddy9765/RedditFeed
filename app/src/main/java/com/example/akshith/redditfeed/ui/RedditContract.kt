package com.example.akshith.redditfeed.ui

interface RedditContract {

    interface IRedditPresenter {
        fun onAttachView(redditView: RedditView)
        fun fetchRedditData()
        fun onDestroyView()
        fun onRedditRowItemClicked(selfText: String)
    }

    interface RedditView {
        fun initViews()
        fun setData(redditData: ArrayList<RedditViewModel>)
        fun showProgress()
        fun hideProgress()
        fun handleRedditError()
        fun showSelfText(selfText: String)
    }
}