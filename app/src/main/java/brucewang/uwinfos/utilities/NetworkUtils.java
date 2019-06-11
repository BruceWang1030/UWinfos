package brucewang.uwinfos.utilities;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import brucewang.uwinfos.models.Event;
import brucewang.uwinfos.models.EventsResponse;

public class NetworkUtils {
    private static final String API = "https://api.uwaterloo.ca/v2";
    private static final String EVENTS_ENTPOINT = "/events";
    private static final String EVENT_DETAIL_ENTPOINT = "/event/%s/%s";
    private static final String format = ".json?";
    private static final String KEY = "key=df31511c2940dc6a0c9aa187c87bb0da";

    private static final String EVENTS_URL = API + EVENTS_ENTPOINT + format + KEY;
    private static final String EVENTS_DETAIL_URL = API + EVENT_DETAIL_ENTPOINT + format + KEY;

    public static List<Event> getEvents() {
        Gson gson = new Gson();
        String json = "";
        try {
            URL url = new URL(EVENTS_URL);
            json = getResponseFromURL(url);
        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        EventsResponse response = gson.fromJson(json,EventsResponse.class);
        return response.getData();
    }

    private static String getResponseFromURL(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            String ret = null;
            if (scanner.hasNext()) {
                ret = scanner.next();
            }
            scanner.close();
            return ret;
        } finally {
            urlConnection.disconnect();
        }
    }

}
