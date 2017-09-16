package justor.hackernews;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

/**
 * Created by Lenovo on 16.09.2017.
 */

public class Article extends Activity {

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

    }
}
