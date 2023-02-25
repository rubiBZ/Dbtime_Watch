package com.example.Dbtime_Watch;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.Dbtime_Wathc.R;

public class MainActivity3 extends Activity {

    Integer hr = 12;
    View lo;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        if(hr>6 && hr<19){
            lo = findViewById(R.id.mn);
            lo.setBackgroundResource(R.raw.daysqr);
        }

        findViewById(R.id.imageView12).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity3.this, MainActivity6.class);
                //myIntent.putExtra("key", value); //Optional parameters
                MainActivity3.this.startActivity(myIntent);
            }
        });
        findViewById(R.id.imageView11).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity3.this, MainActivity5.class);
                //myIntent.putExtra("key", value); //Optional parameters
                MainActivity3.this.startActivity(myIntent);
            }
        });

        findViewById(R.id.imageView).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity3.this, MainActivity2.class);
                MainActivity3.this.startActivity(myIntent);
            }
        });



        findViewById(R.id.imageView2).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity3.this, MainActivity10.class);
                //myIntent.putExtra("key", value); //Optional parameters
                MainActivity3.this.startActivity(myIntent);
            }
        });
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity3.this, MainActivity8.class);
                //myIntent.putExtra("key", value); //Optional parameters
                MainActivity3.this.startActivity(myIntent);
            }
        });
    }
}