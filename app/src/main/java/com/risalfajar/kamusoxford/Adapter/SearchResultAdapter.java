package com.risalfajar.kamusoxford.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.risalfajar.kamusoxford.Entity.SearchResult;
import com.risalfajar.kamusoxford.R;

public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.WordViewHolder> {

    private Context context;
    private SearchResult searchResult;

    public SearchResultAdapter(Context context) {
        this.context = context;
    }

    //region Getter and Setter
    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public SearchResult getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(SearchResult searchResult) {
        this.searchResult = searchResult;
    }

    //endregion

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_word, viewGroup, false);
        return new WordViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder wordViewHolder, int i) {
        wordViewHolder.tvWord.setText(getSearchResult().getResults().get(i).getWord());
    }

    @Override
    public int getItemCount() {
        if(getSearchResult() != null)
            return getSearchResult().getResults().size();
        else
            return 0;
    }

    public class WordViewHolder extends RecyclerView.ViewHolder {

        TextView tvWord;

        public WordViewHolder(@NonNull View itemView) {
            super(itemView);
            tvWord = itemView.findViewById(R.id.tv_word);
        }
    }
}
