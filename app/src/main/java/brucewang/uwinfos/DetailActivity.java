package brucewang.uwinfos;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

import org.sufficientlysecure.htmltextview.HtmlTextView;

import brucewang.uwinfos.models.EventDetail;
import brucewang.uwinfos.utilities.NetworkUtils;

public class DetailActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<EventDetail> {

    private TextView mContent;
    private HtmlTextView mDescription;

    private String mEventId;
    private String mEventSite;
    private static final int LOADER_ID = 44;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mContent = findViewById(R.id.tv_content);
        mDescription = findViewById(R.id.html_text);

        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(MainActivity.TAG)) {
                String[] value = intent.getStringArrayExtra(MainActivity.TAG);
                mEventId = value[0];
                mEventSite = value[1];
            }
        }
        getSupportLoaderManager().initLoader(LOADER_ID, null, this);
    }

    @NonNull
    @Override
    public Loader<EventDetail> onCreateLoader(int i, @Nullable Bundle bundle) {
        return new AsyncTaskLoader<EventDetail>(this) {
            EventDetail mData = null;

            @Override
            protected void onStartLoading() {
                if (mData != null) {
                    deliverResult(mData);
                } else {
                    forceLoad();
                }
            }

            @Nullable
            @Override
            public EventDetail loadInBackground() {
                return NetworkUtils.getEventDetail(mEventSite, mEventId);
            }

            @Override
            public void deliverResult(@Nullable EventDetail data) {
                mData = data;
                super.deliverResult(data);
            }
        };
    }

    @Override
    public void onLoadFinished(@NonNull Loader<EventDetail> loader, EventDetail eventDetail) {
        mDescription.setHtml(eventDetail.getDescription_raw());
    }

    @Override
    public void onLoaderReset(@NonNull Loader<EventDetail> loader) {

    }
}
