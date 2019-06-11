package brucewang.uwinfos.models;

import java.util.List;

public class Event {

    private int id;
    private String site;
    private String site_name;
    private String title;
    private List<EventTime> times;
    private List<String> type;
    private String link;
    private String updated;

    public int getId() {
        return id;
    }

    public String getSite() {
        return site;
    }

    public String getSite_name() {
        return site_name;
    }

    public String getTitle() {
        return title;
    }

    public List<EventTime> getTimes() {
        return times;
    }

    public List<String> getType() {
        return type;
    }

    public String getLink() {
        return link;
    }

    public String getUpdated() {
        return updated;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public void setSite_name(String site_name) {
        this.site_name = site_name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTimes(List<EventTime> times) {
        this.times = times;
    }

    public void setType(List<String> type) {
        this.type = type;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public class EventTime {
        private String start;
        private String end;

        public String getStart() {
            return start;
        }

        public String getEnd() {
            return end;
        }

        public void setStart(String start) {
            this.start = start;
        }

        public void setEnd(String end) {
            this.end = end;
        }
    }
}
