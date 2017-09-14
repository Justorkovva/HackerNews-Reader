package justor.hackernews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.oc.hnapp.android.HNQueryTask;

public class MainActivity extends AppCompatActivity {

    private HNQueryTask task = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RecyclerView rv = (RecyclerView) findViewById(R.id.list);
        rv.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter adapter= new MyAdapter();
        rv.setAdapter(adapter);
        task=new HNQueryTask(adapter, 80, 1);
        task.execute();
        final ProgressBar progress = (ProgressBar) findViewById(R.id.progress);
        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                progress.setVisibility(View.GONE);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        task.cancel(true);
    }
}
