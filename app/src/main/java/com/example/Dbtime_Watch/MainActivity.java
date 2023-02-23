package com.example.Dbtime_Watch;

import android.Manifest;
import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkRequest;

import com.example.Dbtime_Wathc.databinding.ActivityMainBinding;
import com.example.Dbtime_Wathc.R;

public class MainActivity extends Activity {

   private TextView mTextView;
    private ActivityMainBinding binding;

   /*
    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel("12", name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    */

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("RRubi", "ALREADY GRANTED");

     binding = ActivityMainBinding.inflate(getLayoutInflater());
      setContentView(binding.getRoot());

/*
        createNotificationChannel();

        WorkManager.getInstance(this).cancelAllWorkByTag("cleanup");
        WorkManager.getInstance(this).cancelAllWork();
        PeriodicWorkRequest PSN = null;
        WorkRequest PSN = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //PSN = new PeriodicWorkRequest.Builder(ScheduleNotifications.class, 1, TimeUnit.HOURS)
            PSN = new OneTimeWorkRequest.Builder(com.example.Dbtime_Watch.ScheduleNotifications.class)
                    .addTag("cleanup")
                    .build();
            WorkManager.getInstance(this).enqueue(PSN);
        }


        //WorkManager.getInstance(this).enqueue(PSN);
 */
/*
        if (checkSelfPermission(Manifest.permission.BODY_SENSORS) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions( new String[]{Manifest.permission.BODY_SENSORS}, 1);
        } else {
            Log.d("TAG", "ALREADY GRANTED");
        }

 */

        mTextView = binding.text;
        (new Handler()).postDelayed(this::gotomenue, 3000);
        findViewById(R.id.text).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, com.example.Dbtime_Watch.MainActivity3.class);
                MainActivity.this.startActivity(myIntent);
            }
        });
    }

    private void gotomenue() {
        Intent myIntent = new Intent(MainActivity.this, com.example.Dbtime_Watch.MainActivity3.class);
        MainActivity.this.startActivity(myIntent);
    }
}