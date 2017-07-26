package com.camacho.scrapperapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import models.ModelRecyclerViewScrapper;
import recyclerview.adapters.AdapterScrapper;

public class ActivityMain extends AppCompatActivity {

    private EditText etScrapperText;
    private Button btnMakeRequest;
    private RecyclerView rvScrapper;
    private static final String NOEMBEDURL = "https://noembed.com/embed?url=";
    private Utilities utilities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etScrapperText = (EditText) findViewById(R.id.etScrapperText);
        btnMakeRequest = (Button) findViewById(R.id.btnMakeRequest);
        rvScrapper = (RecyclerView) findViewById(R.id.rvScrapper);

        utilities = new Utilities(this);

        rvScrapper.setLayoutManager(new LinearLayoutManager(this));
        rvScrapper.setHasFixedSize(true);
        rvScrapper.setItemAnimator(new DefaultItemAnimator());
        btnMakeRequest.setOnClickListener(btnMakeRequestListener());
    }

    private View.OnClickListener btnMakeRequestListener() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = etScrapperText.getText().toString();
                String textUrl = utilities.getLinkFromString(text);
                text = text.replace(textUrl, "");
                //utilities.getLinkFromString(text);
                if (textUrl.equals("")) {
                    ModelRecyclerViewScrapper modelScrapper = new ModelRecyclerViewScrapper("", "", "", text);
                    AdapterScrapper adapterScrapper = new AdapterScrapper(modelScrapper, ActivityMain.this);
                    rvScrapper.setAdapter(adapterScrapper);
                } else {
                    makeRequest(text, textUrl);
                }
            }
        };

        return listener;
    }

    private void makeRequest(final String text, final String url) {
        //final String inputText = text;
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, NOEMBEDURL + url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("Response: ", response.toString());
                        Log.d("Title", response.optString("title"));
                        String title = response.optString("title");
                        String thumbnailUrl = response.optString("thumbnail_url");

                        ModelRecyclerViewScrapper modelScrapper = new ModelRecyclerViewScrapper(title, thumbnailUrl, url, text);
                        AdapterScrapper adapterScrapper = new AdapterScrapper(modelScrapper, ActivityMain.this);
                        rvScrapper.setAdapter(adapterScrapper);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error: ", error.getMessage());
                    }
                }
        );

        VolleySingleton.getInstance(this).addToRequestQueue(request);
    }

}
