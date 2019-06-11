package brucewang.uwinfos;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import brucewang.uwinfos.models.Event;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {
    List<Event> mEventsData;

    public EventAdapter() {

    }

    public void setEventsData(List<Event> events) {
        mEventsData = events;
        notifyDataSetChanged();
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
        Event event = mEventsData.get(i);
        eventViewHolder.mSessionNameTextView.setText(event.getTitle());
        eventViewHolder.mDateTextView.setText(event.getTimes().get(0).getStart());
        eventViewHolder.mLocationTextView.setText(event.getSite_name());
    }

    @Override
    public int getItemCount() {
        if (mEventsData == null) return 0;
        return mEventsData.size();
    }

    public class EventViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView mSessionNameTextView;
        public final TextView mDateTextView;
        public final TextView mLocationTextView;

        public EventViewHolder (View view) {
            super(view);
            mSessionNameTextView = view.findViewById(R.id.tv_session_name);
            mDateTextView = view.findViewById(R.id.tv_date);
            mLocationTextView = view.findViewById(R.id.tv_location);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }

}
