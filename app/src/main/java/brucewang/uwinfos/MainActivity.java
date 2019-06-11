package brucewang.uwinfos;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

import brucewang.uwinfos.models.Event;
import brucewang.uwinfos.utilities.NetworkUtils;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Event>> {

    private RecyclerView mEventListRecyclerView;
    private ProgressBar mProgressBar;

    private EventAdapter mAdapter;

    private static final int LOADER_ID = 22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEventListRecyclerView = findViewById(R.id.rv_event_list);
        mProgressBar = findViewById(R.id.pb_loading);

        LinearLayoutManager layoutManager = new LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL, false);
        mEventListRecyclerView.setLayoutManager(layoutManager);

        mEventListRecyclerView.setHasFixedSize(true);

        mAdapter = new EventAdapter();
        mEventListRecyclerView.setAdapter(mAdapter);

        getSupportLoaderManager().initLoader(LOADER_ID,null,this);
    }


    @NonNull
    @Override
    public Loader<List<Event>> onCreateLoader(int i, @Nullable Bundle bundle) {
        return new AsyncTaskLoader<List<Event>>(this) {
            List<Event> mData = null;

            @Override
            protected void onStartLoading() {
                showProgressBar();
                if (mData != null) {
                    deliverResult(mData);
                } else {
                    forceLoad();
                }
            }

            @Nullable
            @Override
            public List<Event> loadInBackground() {
                return NetworkUtils.getEvents();
            }

            @Override
            public void deliverResult(@Nullable List<Event> data) {
                mData = data;
                super.deliverResult(data);
            }
        };
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<Event>> loader, List<Event> events) {
        mAdapter.setEventsData(events);
        showRecyclerView();
    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<Event>> loader) {

    }

    private void showRecyclerView() {
        mProgressBar.setVisibility(View.INVISIBLE);
        mEventListRecyclerView.setVisibility(View.VISIBLE);
    }

    private void showProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
        mEventListRecyclerView.setVisibility(View.INVISIBLE);
    }

}
