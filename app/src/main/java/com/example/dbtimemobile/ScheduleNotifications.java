package com.example.dbtimemobile;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import java.time.OffsetTime;

@RequiresApi(api = Build.VERSION_CODES.O)
public class ScheduleNotifications extends Worker {

    public ScheduleNotifications(
            @NonNull Context context,
            @NonNull WorkerParameters params) {
        super(context, params);
    }

        OffsetTime offset = OffsetTime.now();
        Integer hr = offset.getHour();


    public Result doWork() {

        // Do the work here--in this case, upload the images.
       // if(hr == 7 || hr == 14 || hr == 20 ) {
            createNotification();
       // }
        // Indicate whether the work finished successfully with the Result
        return Result.success();
    }

    private void createNotification() {
        Log.d("rubi","in createNotification()");
        Intent intent = new Intent(getApplicationContext(), AlertDetails.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), "9")
                .setSmallIcon(R.raw.wings)
                .setContentTitle("מה מצב הרוח שלך?")
                .setContentText("היי, אנא לחץ על האימוג'י שמתאר את מצב הרוח שלך")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplicationContext());
        notificationManager.notify(8, builder.build());
    }
}