package com.risalfajar.kamusoxford.service.networkdatasource

import com.risalfajar.kamusoxford.service.entity.SearchResult
import com.risalfajar.kamusoxford.service.entity.Word
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface OxfordApi {
    @GET("search/en-us")
    fun searchWord(@Query("q") keyword: String?, @Header("app_id") appId: String?, @Header("app_key") apiKey: String?): Call<SearchResult?>?

    @GET("entries/en-us/{id}")
    fun getWord(@Path("id") wordId: String?): Call<List<Word?>?>?
}