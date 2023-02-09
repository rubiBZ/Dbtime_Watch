package com.example.Dbtime_Watch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.Dbtime_Wathc.R;

public class MainActivity8 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);


        findViewById(R.id.textView9).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity8.this, MainActivity7.class);
                MainActivity8.this.startActivity(myIntent);
            }
        });

        findViewById(R.id.imageView10).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity8.this, MainActivity9.class);
                MainActivity8.this.startActivity(myIntent);
            }
        });


    }
}