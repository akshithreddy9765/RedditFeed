package com.example.akshith.redditfeed.ui

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import android.widget.Toast
import com.example.akshith.redditfeed.R
import com.example.akshith.redditfeed.RedditApp
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class RedditActivity : AppCompatActivity(), RedditContract.RedditView, RedditRowItemClickListener {

    @Inject
    lateinit var redditPresenter: RedditContract.IRedditPresenter

    private val redditAdapter by lazy { RedditAdapter(this) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RedditApp.getComponent()?.inject(this)
        redditPresenter.let {
            it.onAttachView(this)
            it.fetchRedditData()
        }
    }

    override fun initViews() {
        reddit_feed_list.let {
            it.layoutManager = LinearLayoutManager(this,LinearLayout.VERTICAL,false)
            it.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))
            it.adapter = redditAdapter
        }
    }

    override fun setData(redditData: ArrayList<RedditViewModel>) {
        redditAdapter.setData(redditData)
    }

    override fun showProgress() {
        progress_bar.show()
    }

    override fun hideProgress() {
        progress_bar.hide()
    }

    override fun handleRedditError() {
        Toast.makeText(this, "Error Fetching Reddit Data", Toast.LENGTH_LONG).show()
    }

    override fun onClick(selfText: String) {
        AlertDialog.Builder(this)
                .create().let {
                    it.setMessage(selfText)
                    it.setButton(AlertDialog.BUTTON_POSITIVE, "OK") { dialogInterface, _ -> dialogInterface.dismiss() }
                    it.show()
                }
    }

    override fun onDestroy() {
        super.onDestroy()
        redditPresenter.onDestroyView()
    }
}
