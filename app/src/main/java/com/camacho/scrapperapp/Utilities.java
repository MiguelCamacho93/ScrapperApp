package com.camacho.scrapperapp;

import android.content.Context;
import android.util.Log;
import android.util.Patterns;
import android.widget.Toast;

import java.util.regex.Matcher;

/**
 * Created by Miguel Camacho on 25/07/2017.
 */

public class Utilities {
    private Context context;

    public Utilities(Context context) {
        this.context = context;
    }

    public String getLinkFromString(String text) {
        Matcher matcher = Patterns.WEB_URL.matcher(text);
        String url = "";
        while (matcher.find()) {
            url = matcher.group();
            Log.d("URL: ", url);
        }

        return url;
    }

}
