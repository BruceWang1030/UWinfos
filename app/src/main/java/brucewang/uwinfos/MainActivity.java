package brucewang.uwinfos;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mEventListRecyclerView;

    private EventAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEventListRecyclerView = (RecyclerView) findViewById(R.id.rv_event_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL, false);
        mEventListRecyclerView.setLayoutManager(layoutManager);
        mEventListRecyclerView.setHasFixedSize(true);
        mAdapter = new EventAdapter();
        mEventListRecyclerView.setAdapter(mAdapter);
    }

}
