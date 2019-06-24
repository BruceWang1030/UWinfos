package brucewang.uwinfos.models;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;

public class EventDetail {
    //TODO: implement EventDetail
    private int id;
    private String title;
    private String description;
    private String description_raw;
    private ArrayList<DetailTime> times;
    private String cost;
    private ArrayList<String> audience;
    private ArrayList<String> tags;
    private ArrayList<String> type;
    private Website website;
    private Image image;
    private Location location;
    private String site_name;
    private String site_id;
    private int revision_id;
    private String link;
    private String link_calendar;
    private String updated;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription_raw() {
        return description_raw;
    }

    public void setDescription_raw(String description_raw) {
        this.description_raw = description_raw;
    }

    public ArrayList<DetailTime> getTimes() {
        return times;
    }

    public void setTimes(ArrayList<DetailTime> times) {
        this.times = times;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public ArrayList<String> getAudience() {
        return audience;
    }

    public void setAudience(ArrayList<String> audience) {
        this.audience = audience;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public ArrayList<String> getType() {
        return type;
    }

    public void setType(ArrayList<String> type) {
        this.type = type;
    }

    public Website getWebsite() {
        return website;
    }

    public void setWebsite(Website website) {
        this.website = website;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getSite_name() {
        return site_name;
    }

    public void setSite_name(String site_name) {
        this.site_name = site_name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


    public class DetailTime {
        private String start;
        private String end;
        private String start_day;
        private String start_date;
        private String start_time;
        private String end_day;
        private String end_date;
        private String end_time;

        public String getStart() {
            return start;
        }

        public void setStart(String start) {
            this.start = start;
        }

        public String getEnd() {
            return end;
        }

        public void setEnd(String end) {
            this.end = end;
        }

        public String getStart_day() {
            return start_day;
        }

        public void setStart_day(String start_day) {
            this.start_day = start_day;
        }

        public String getStart_date() {
            return start_date;
        }

        public void setStart_date(String start_date) {
            this.start_date = start_date;
        }

        public String getStart_time() {
            return start_time;
        }

        public void setStart_time(String start_time) {
            this.start_time = start_time;
        }

        public String getEnd_day() {
            return end_day;
        }

        public void setEnd_day(String end_day) {
            this.end_day = end_day;
        }

        public String getEnd_date() {
            return end_date;
        }

        public void setEnd_date(String end_date) {
            this.end_date = end_date;
        }

        public String getEnd_time() {
            return end_time;
        }

        public void setEnd_time(String end_time) {
            this.end_time = end_time;
        }
    }

    public class Website {
        private String title;
        private String url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public class Image{
        private int id;
        private String file;
        private String alt;
        private String mime;
        private int size;
        private int width;
        private int height;
        private String url;
    }

    public class Location {
        private int id;
        private String name;
        private String street;
        private String additional;
        private String city;
        private String province;
        private String postal_code;
        private String country;
        private String latitude;
        private String longitude;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getAdditional() {
            return additional;
        }

        public void setAdditional(String additional) {
            this.additional = additional;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getPostal_code() {
            return postal_code;
        }

        public void setPostal_code(String postal_code) {
            this.postal_code = postal_code;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }
    }
}
