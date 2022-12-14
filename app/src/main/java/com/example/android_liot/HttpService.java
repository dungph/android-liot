package com.example.android_liot;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class HttpService {
    ArrayList<String> devices_url = new ArrayList<>();
    String url;
    RequestQueue mQueue;
    Context context;

    public HttpService(Context context) {
        this.context = context;
        devices_url.add("http://192.168.71.1/schema");
        mQueue = Volley.newRequestQueue(context);
        jsonParse();
ne
    }

    public ArrayList<getListDevice() {

    }
    void setUrl(String url) {

    }

    void jsonParse(String url) {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject json_properties = response.getJSONObject("properties");
                            Iterator<String> keys = json_properties.keys();
                            properties.clear();

                            while (keys.hasNext()) {
                                String key = keys.next();
                                JSONObject value = json_properties.getJSONObject(key);
                                properties.add(value);
                                Log.i("log", value.toString());
                            }


                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });
        mQueue.add(request);
    }

}