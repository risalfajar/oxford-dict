package com.risalfajar.kamusoxford.view.activity

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.risalfajar.kamusoxford.BuildConfig
import com.risalfajar.kamusoxford.R
import com.risalfajar.kamusoxford.view.adapter.SearchResultAdapter
import com.risalfajar.kamusoxford.service.entity.SearchResult
import com.risalfajar.kamusoxford.service.networkdatasource.OxfordApi
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private var oxfordApi: OxfordApi? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRetrofit()
        initRecyclerView()

        et_keyword.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) search()
            false
        })
    }

    private fun search() {
        val keyword = et_keyword!!.text.toString().trim()
        if (keyword.isEmpty()) return

        val call = oxfordApi!!.searchWord(keyword, BuildConfig.APP_ID, BuildConfig.API_KEY)

        Toast.makeText(this, "Searching", Toast.LENGTH_SHORT).show()

        call!!.enqueue(object : Callback<SearchResult?> {
            override fun onResponse(call: Call<SearchResult?>, response: Response<SearchResult?>) {
                if (!response.isSuccessful) {
                    tv_search_message!!.text = "Code : ${response.code()}"
                    Toast.makeText(applicationContext, response.errorBody().toString(), Toast.LENGTH_LONG).show()
                } else {
                    val searchResult = response.body()
                    updateSearchResultRecyclerView(searchResult!!)
                }
            }

            override fun onFailure(call: Call<SearchResult?>, t: Throwable) {
                tv_search_message!!.text = ""
                rv_search_results!!.adapter = null
                Toast.makeText(this@MainActivity, "Search error", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun updateSearchResultRecyclerView(results: SearchResult){
        val adapter = rv_search_results.adapter as SearchResultAdapter
        adapter.searchResult = results
        adapter.notifyDataSetChanged()
    }

    private fun initRecyclerView() {
        rv_search_results!!.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = SearchResultAdapter()
        }
    }

    private fun initRetrofit(){
        val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        oxfordApi = retrofit.create(OxfordApi::class.java)
    }
}