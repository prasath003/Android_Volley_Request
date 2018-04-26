package com.macintosh.prasath.android_volley_request;

import com.android.volley.VolleyError;


public interface VolleyResponseListener {

        void onError(VolleyError message);

        void onResponse(String response);

}
