package com.example.akshith.redditfeed.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.akshith.redditfeed.R
import kotlinx.android.synthetic.main.reddit_row_item.view.*

class RedditAdapter(private val redditRowItemClickListener: RedditRowItemClickListener) : RecyclerView.Adapter<RedditAdapter.RedditItemViewHolder>() {

    private var redditDataList: ArrayList<RedditViewModel> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RedditItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.reddit_row_item,null,false)
        return RedditItemViewHolder(view)
    }

    override fun getItemCount(): Int = redditDataList.size

    override fun onBindViewHolder(holder: RedditItemViewHolder, position: Int) {
        holder.bindRedditData(redditDataList[position])
    }

    fun setData(redditData: ArrayList<RedditViewModel>) {
        this.redditDataList = redditData
        notifyDataSetChanged()
    }

    inner class RedditItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bindRedditData(data: RedditViewModel) {
            view.reddit_title.text = data.title
            view.reddit_comments.text = data.numberOfComments
            view.reddit_author.text = data.authorName
            view.setOnClickListener { redditRowItemClickListener.onClick(data.selfText) }
        }
    }
}