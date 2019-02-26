package com.risalfajar.kamusoxford;

import com.risalfajar.kamusoxford.Entity.SearchResult;
import com.risalfajar.kamusoxford.Entity.Word;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface OxfordApi {

    @GET("search/en")
    Call<SearchResult> searchWord(@Query("q") String keyword, @Header("app_id") String appId, @Header("app_key") String apiKey);

    @GET("entries/en/{id}")
    Call<List<Word>> getWord(@Path("id") String wordId);
}
