package com.camacho.scrapperapp;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Miguel Camacho on 25/07/2017.
 */

public class VolleySingleton {
    private static VolleySingleton instance;
    private static Context context;
    private RequestQueue requestQueue;

    private VolleySingleton(Context context) {
        this.context = context;
        requestQueue = getRequestQueue();
    }

    public static synchronized  VolleySingleton getInstance(Context context) {
        if (instance == null) {
            instance = new VolleySingleton(context);
        }

        return instance;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }

        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> request) {
        getRequestQueue().add(request);
    }
}
