package justor.hackernews;

import android.support.v7.widget.RecyclerView;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.oc.hnapp.android.HNArticle;
import com.oc.hnapp.android.HNQueryCallback;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.HNArticleViewHolder> implements HNQueryCallback {

    private final List<HNArticle> _articles = new ArrayList<HNArticle>();

    @Override
    public void onArticlesReceived(List<HNArticle> articles, boolean hasMore) {
        _articles.addAll(articles);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return _articles.size();
    }

    @Override
    public HNArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_cell, parent, false);
        return new HNArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HNArticleViewHolder holder, int position) {
        holder.bind(_articles.get(position));
    }

    public static class HNArticleViewHolder extends RecyclerView.ViewHolder {

        private final TextView _title;

        public HNArticleViewHolder(View view) {
            super(view);
            _title = (TextView) view.findViewById(R.id.title);
        }

        public void bind(HNArticle article) {
            _title.setText(article.title);
        }
    }
}