package com.example.dbtimemobile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;


public class MainActivity10 extends Activity {

    public Integer size = 100;
    public String direction = "up";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);


        ImageView bl = (ImageView) findViewById(R.id.imageView8);
        ImageView bt_start = (ImageView) findViewById(R.id.imageView6);
        ImageView bt_stop = (ImageView) findViewById(R.id.imageView7);
        MediaPlayer ring1= MediaPlayer.create(MainActivity10.this,R.raw.meditation_voice);

        final Handler h = new Handler();
        bt_start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ring1.start();
                direction = "up";
                h.postDelayed(new Runnable() {
                    public void run() {
                        size += 1;
                        bl.getLayoutParams().height = size;
                        bl.getLayoutParams().width =size;
                        bl.requestLayout();
                        if (direction=="up"&&size<300) h.postDelayed(this, 200);
                    }
                }, 200); // 1 second delay (takes millis)
            }
        });

        bt_stop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ring1.pause();
                direction = "down";
                h.postDelayed(new Runnable() {
                    public void run() {
                        size -= 1;
                        bl.getLayoutParams().height = size;
                        bl.getLayoutParams().width =size;
                        bl.requestLayout();
                        if(direction == "down"&&size>100) h.postDelayed(this, 200);
                    }
                }, 200); // 1 second delay (takes millis)

            }
        });
    }
    }