package com.macintosh.prasath.android_volley_request;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class Volley_Tools {

    public static void get(Context context, String url, final VolleyResponseListener listener) {

        // Initialize a new StringRequest
        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        listener.onResponse(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        listener.onError(error);

                    }
                });

        // Accessing the RequestQueue through singleton class.
        Volley_Singleton.getInstance(context).addToRequestQueue(stringRequest);
    }

    public static void post(Context context, String url, final Map<String, String> getParams,
                                   final VolleyResponseListener listener) {

        // Initialize a new StringRequest
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        listener.onResponse(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        listener.onError(error);
                    }
                })


        {
            /**
             * Passing parameters
             * */

            @Override
            public Map<String, String> getParams() {
                return getParams;
            }

            /**
             * Passing headers
             * */
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                // Give header as per your server supports

                //headers.put("Content-Type", "application/json; charset=utf-8");
                //headers.put("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
                return headers;
            }


        };

        // needed only if large amount of data is transfered and you need set time out
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(10000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        // Accessing the RequestQueue through singleton class - volleyrequest
        Volley_Singleton.getInstance(context).addToRequestQueue(stringRequest);
    }
}
