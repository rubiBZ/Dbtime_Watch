package com.example.dbtimemobile;

import static com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_SHORT;
import static com.google.android.material.snackbar.Snackbar.make;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity5 extends Activity implements SensorEventListener {

    TextView mTextViewHeart;
    String TAG;
    String hr="tt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        TAG = "test";
        mTextViewHeart = (TextView) findViewById(R.id.textView4);
        Button bt = findViewById(R.id.button3);
        bt.setVisibility(View.INVISIBLE);
        (new Handler()).postDelayed(this::showBtn, 12000);
        TextView tv2 = findViewById(R.id.textView2);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getHeartRate();

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String ms = " נשלח דופק: "+hr+ "\n"+" בזמן: "+currentTimeStr();
                findViewById(R.id.button3).setVisibility(View.INVISIBLE);
                tv2.setVisibility(View.VISIBLE);
                tv2.setText(ms);
                (new Handler()).postDelayed(this::goHome, 5000);
            }

            private void goHome() {
                Intent myIntent = new Intent(MainActivity5.this, MainActivity3.class);
                MainActivity5.this.startActivity(myIntent);
                }
        });
    }

    private void showBtn() {

        findViewById(R.id.button3).setVisibility(View.VISIBLE);
        TextView tv = findViewById(R.id.textView4);
        tv.setTextSize(40);
    }


        private void getHeartRate() {
            SensorManager mSensorManager = ((SensorManager)getSystemService(SENSOR_SERVICE));
            Sensor mHeartRateSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_HEART_RATE);
            mSensorManager.registerListener(this, mHeartRateSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }

        private String currentTimeStr() {
            Calendar c = Calendar.getInstance();
            SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
            return df.format(c.getTime());
        }

        public void onSensorChanged(SensorEvent event) {
            if (event.sensor.getType() == Sensor.TYPE_HEART_RATE) {
                String msg = "" + (int)event.values[0];
                hr= String.valueOf(event.values[0]);
                hr= String.valueOf((int)event.values[0]);
               // mTextViewHeart.setTextSize(40);
                if ((int)event.values[0]>0) mTextViewHeart.setText(msg);
                Log.d(TAG, "#1 " + msg);
            }
            else
                Log.d(TAG, "#2 "+"Unknown sensor type");
        }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
    }
}