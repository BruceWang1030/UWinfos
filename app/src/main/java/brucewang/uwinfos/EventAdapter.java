package brucewang.uwinfos;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {
    String[] events = new String[10];

    public EventAdapter() {
        for (int i = 0; i < 10; i++) {
            events[i] = "e" + i;
        }
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_layout, viewGroup, false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder eventViewHolder, int i) {
        eventViewHolder.mSessionNameTextView.setText(events[i]);
    }

    @Override
    public int getItemCount() {
        return events.length;
    }

    public class EventViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView mSessionNameTextView;
        public final TextView mDateTextView;
        public final TextView mLocationTextView;

        public EventViewHolder (View view) {
            super(view);
            mSessionNameTextView = (TextView) view.findViewById(R.id.tv_session_name);
            mDateTextView = (TextView) view.findViewById(R.id.tv_date);
            mLocationTextView = (TextView) view.findViewById(R.id.tv_location);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }

}
