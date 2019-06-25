package brucewang.uwinfos.models;

import java.util.ArrayList;

public class EventsResponse {

    private MetaData meta;
    private ArrayList<Event> data;

    public MetaData getMeta() {
        return meta;
    }

    public ArrayList<Event> getData() {
        return data;
    }

    public class MetaData {
        private int requests;
        private int timestamp;
        private int status;
        private int version;
        private int method_id;
        private String message;

        public int getRequests() {
            return requests;
        }

        public int getTimestamp() {
            return timestamp;
        }

        public int getStatus() {
            return status;
        }

        public int getVersion() {
            return version;
        }

        public int getMethod_id() {
            return method_id;
        }

        public String getMessage() {
            return message;
        }

        public void setRequests(int requests) {
            this.requests = requests;
        }

        public void setTimestamp(int timestamp) {
            this.timestamp = timestamp;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public void setMethod_id(int method_id) {
            this.method_id = method_id;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
