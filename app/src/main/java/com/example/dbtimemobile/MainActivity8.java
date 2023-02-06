package com.example.dbtimemobile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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