package brucewang.uwinfos.models;

import java.util.ArrayList;

public class EventDetailResponse {
    private EventsResponse.MetaData meta;
    private EventDetail data;

    public EventsResponse.MetaData getMeta() {
        return meta;
    }

    public EventDetail getData() {
        return data;
    }
}
