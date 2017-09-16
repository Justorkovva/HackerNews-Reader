package justor.hackernews;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Article extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article);
        TextView textView=(TextView) findViewById(R.id.textView);

        Intent myIntent=getIntent();
        String url=myIntent.getStringExtra("url");
        String title=myIntent.getStringExtra("title");

        textView.setText(title);
        WebView myWebView = (WebView) findViewById(R.id.webView);
        myWebView.loadUrl(url);
        myWebView.getSettings().setJavaScriptEnabled(true);

        myWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return false;
            }
        });

        final ProgressBar progress = (ProgressBar) findViewById(R.id.progress2);
        HNArticlesAdapter _adapter=new HNArticlesAdapter();
        _adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                progress.setVisibility(View.GONE);
            }
        });
    }
}