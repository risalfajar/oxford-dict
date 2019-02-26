package com.risalfajar.kamusoxford;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.risalfajar.kamusoxford.Adapter.SearchResultAdapter;
import com.risalfajar.kamusoxford.Entity.SearchResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    EditText etKeyword;
    TextView tvSearchMessage;
    RecyclerView rvSearchResults;

    OxfordApi oxfordApi;

    SearchResultAdapter searchResultAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etKeyword = findViewById(R.id.et_keyword);
        tvSearchMessage = findViewById(R.id.tv_search_message);
        rvSearchResults = findViewById(R.id.rv_search_results);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        oxfordApi = retrofit.create(OxfordApi.class);
        showSearchResultList(null);

        etKeyword.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER)
                    search();
                return false;
            }
        });
    }

    void search(){
        Toast.makeText(this, "Searching", Toast.LENGTH_SHORT).show();
        String keyword = etKeyword.getText().toString().trim();
        Call<SearchResult> call = oxfordApi.searchWord(keyword, BuildConfig.APP_ID, BuildConfig.API_KEY);

        call.enqueue(new Callback<SearchResult>() {
            @Override
            public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
                if(!response.isSuccessful()){
                    tvSearchMessage.setText("Code : " + response.code());
                }else{
                    SearchResult searchResult = response.body();
                    searchResultAdapter.setSearchResult(searchResult);
                    searchResultAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<SearchResult> call, Throwable t) {
                tvSearchMessage.setText("");
                rvSearchResults.setAdapter(null);
                Toast.makeText(MainActivity.this, "Search error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showSearchResultList(SearchResult results){
        rvSearchResults.setLayoutManager(new LinearLayoutManager(this));
        searchResultAdapter = new SearchResultAdapter(this);
        searchResultAdapter.setSearchResult(results);
        rvSearchResults.setAdapter(searchResultAdapter);
    }
}
