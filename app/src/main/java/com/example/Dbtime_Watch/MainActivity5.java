package com.example.Dbtime_Watch;

import static com.google.android.material.snackbar.Snackbar.make;

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

import androidx.annotation.NonNull;

import com.example.Dbtime_Wathc.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class MainActivity5 extends Activity implements SensorEventListener {

    TextView mTextViewHeart,tv2;
    String TAG;
    String hr="tt",email;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    public FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        TAG = "test";
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        email = user.getEmail();

        mTextViewHeart = (TextView) findViewById(R.id.textView4);
        Button bt = findViewById(R.id.button3);
        bt.setVisibility(View.INVISIBLE);
        (new Handler()).postDelayed(this::showBtn, 12000);
        tv2 = findViewById(R.id.textView2);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getHeartRate();

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                addHeartRateToDB();
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
            if ((int)event.values[0]>0) mTextViewHeart.setText(msg);
            Log.d(TAG, "#1 " + msg);
        }
        else
            Log.d(TAG, "#2 "+"Unknown sensor type");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void addHeartRateToDB(){
        String now = currentTimeStr();
        Long nowMS = System.currentTimeMillis();

        Map<String, Object> sample = new HashMap<>();
        sample.put("heartRate", hr);
        sample.put("dateTime", now);
        sample.put("timeMS", nowMS);

        db.collection("users").document(email)
                .collection("measures").document("list")
                .set(sample)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        String ms = " נשלח דופק: "+hr+ "\n"+" בזמן: "+currentTimeStr();
                        findViewById(R.id.button3).setVisibility(View.INVISIBLE);
                        tv2.setVisibility(View.VISIBLE);
                        tv2.setText(ms);
                        (new Handler()).postDelayed(this::goHome, 5000);
                        Log.d("Rubi", "DocumentSnapshot successfully written!");
                    }
                    private void goHome() {
                        Intent myIntent = new Intent(MainActivity5.this, MainActivity3.class);
                        MainActivity5.this.startActivity(myIntent);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("Rubi", "Error writing document", e);
                    }
                });
    }
}