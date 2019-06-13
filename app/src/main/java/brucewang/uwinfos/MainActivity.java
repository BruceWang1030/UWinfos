package brucewang.uwinfos;

import android.annotation.SuppressLint;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;

import java.util.List;

import brucewang.uwinfos.models.Event;
import brucewang.uwinfos.utilities.NetworkUtils;

import static android.support.v7.widget.RecyclerView.SCROLL_STATE_IDLE;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Event>> {

    private RecyclerView mEventListRecyclerView;
    private ProgressBar mProgressBar;
    private FloatingActionButton mGoToTopButton;
    private ImageView mNoConnection;

    private EventAdapter mAdapter;

    private static final int LOADER_ID = 22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgressBar = findViewById(R.id.pb_loading);

        mNoConnection = findViewById(R.id.iv_no_connection);
        mGoToTopButton = findViewById(R.id.fab_go_to_top);
        mGoToTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEventListRecyclerView.smoothScrollToPosition(0);
            }
        });

        mEventListRecyclerView = findViewById(R.id.rv_event_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL, false);
        mEventListRecyclerView.setLayoutManager(layoutManager);

        mEventListRecyclerView.setHasFixedSize(true);
        mEventListRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                if (newState == SCROLL_STATE_IDLE) {
                    if (mEventListRecyclerView.canScrollVertically(-1)) {
                        //TODO: show a button for return to top
                        mGoToTopButton.setVisibility(View.VISIBLE);
                    } else {
                        mGoToTopButton.setVisibility(View.GONE);
                    }
                } else {
                    mGoToTopButton.setVisibility(View.GONE);
                }
            }
        });

        mAdapter = new EventAdapter();
        mEventListRecyclerView.setAdapter(mAdapter);

        if (!isConnected()) {
            showNoConnection();
        } else {
            getSupportLoaderManager().initLoader(LOADER_ID, null, this);
        }
        //TODO: use database?
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
        mNoConnection.setVisibility(View.INVISIBLE);
    }

    private void showProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
        mEventListRecyclerView.setVisibility(View.INVISIBLE);
        mNoConnection.setVisibility(View.INVISIBLE);
    }

    private void showNoConnection() {
        mProgressBar.setVisibility(View.INVISIBLE);
        mEventListRecyclerView.setVisibility(View.INVISIBLE);
        mNoConnection.setVisibility(View.VISIBLE);
    }

    private boolean isConnected() {
        ConnectivityManager manager = (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        return info != null && info.isConnected();
    }
}
