package brucewang.uwinfos.data;

import android.provider.BaseColumns;

public class EventContract {

    public static final class EventEntry implements BaseColumns {

        public static final String TABLE_NAME = "event";

        public static final String TITLE = "title";
        public static final String SITE = "site";
        public static final String SITE_NAME = "site_name";
        public static final String TIME_START = "time_start";
        public static final String TIME_END = "time_end";

    }
}
