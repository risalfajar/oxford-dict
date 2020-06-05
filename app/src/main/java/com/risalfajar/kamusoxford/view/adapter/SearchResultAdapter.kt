package com.risalfajar.kamusoxford.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.risalfajar.kamusoxford.view.adapter.SearchResultAdapter.WordViewHolder
import com.risalfajar.kamusoxford.service.entity.SearchResult
import com.risalfajar.kamusoxford.R
import kotlinx.android.synthetic.main.item_word.view.*

class SearchResultAdapter : RecyclerView.Adapter<WordViewHolder>() {
    var searchResult: SearchResult? = null

    //endregion
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): WordViewHolder {
        val itemRow = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_word, viewGroup, false)
        return WordViewHolder(itemRow)
    }

    override fun onBindViewHolder(wordViewHolder: WordViewHolder, i: Int) {
        wordViewHolder.tvWord.text = searchResult!!.results!![i].word
    }

    override fun getItemCount(): Int {
        return if (searchResult != null) searchResult!!.results!!.size else 0
    }

    inner class WordViewHolder(itemView: View) : ViewHolder(itemView) {
        val tvWord: TextView = itemView.tv_word
    }

}