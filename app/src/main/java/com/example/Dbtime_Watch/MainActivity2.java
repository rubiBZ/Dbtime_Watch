package com.example.Dbtime_Watch;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

import com.example.Dbtime_Wathc.R;

import java.util.List;

public class MainActivity2 extends Activity {
    private SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> deviceSensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
        for (int i = 0; i < deviceSensors.size(); i++) {
           Log.d("RRubi", String.valueOf(deviceSensors.get(i)));
       }
    }
}