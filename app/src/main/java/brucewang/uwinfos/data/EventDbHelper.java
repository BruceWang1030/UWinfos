package brucewang.uwinfos.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import brucewang.uwinfos.data.EventContract.EventEntry;

public class EventDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "event.db";

    private static final int DATABASE_VERSION = 1;

    public EventDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_EVENT_TABLE =
                "CREATE TABLE " + EventEntry.TABLE_NAME + " (" +
                        EventEntry._ID          + "INTEGER NOT NULL, " +
                        EventEntry.TITLE        + "TEXT NOT NULL, " +
                        EventEntry.SITE         + "TEXT NOT NULL, " +
                        EventEntry.SITE_NAME    + "TEXT NOT NULL, " +
                        EventEntry.TIME_START   + "TEXT NOT NULL, " +
                        EventEntry.TIME_END     + "TEXT NOT NULL" + ");";

        db.execSQL(SQL_CREATE_EVENT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + EventEntry.TABLE_NAME);
        onCreate(db);
    }
}
