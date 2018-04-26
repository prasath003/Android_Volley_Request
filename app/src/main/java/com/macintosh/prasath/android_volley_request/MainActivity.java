package com.macintosh.prasath.android_volley_request;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.VolleyError;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button requestButton = findViewById(R.id.RBt);

        requestButton.setOnClickListener(new View.OnClickListener() {
            @Override

            //For get
            public void onClick(View v) {
                Volley_Tools.get(MainActivity.this, "your url", new VolleyResponseListener() {
                    @Override
                    public void onError(VolleyError message) {

                    }

                    @Override
                    public void onResponse(String response) {

                    }
                });
            }
        });

        //For post same call the method post Volley_Tools.post
    }
}
