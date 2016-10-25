package com.example.macbookuser.alarmclock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Macbookuser on 10/21/16.
 */
public class myReceiver extends BroadcastReceiver {

    public static final String HOURS_NAME =" ";
    public static final String MINUTES_NAME =" ";
    private int numHours;
    private int numMin;

    public void onReceive(Context context, Intent intent){
        Intent i = new Intent (context, AlarmPage.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);

       // alarm.setExact(AlarmManager.RTC_WAKEUP,timeLeft, PendingIntent.getBroadcast(context,123, intent,PendingIntent.FLAG_UPDATE_CURRENT));


    }
}
