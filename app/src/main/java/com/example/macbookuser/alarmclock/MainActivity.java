package com.example.macbookuser.alarmclock;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.TimePicker;


public class MainActivity extends AppCompatActivity {




    private TimePicker timePicker;
    private Switch switch_sun;
    private Switch switch_mon;
    private Switch switch_tues;
    private Switch switch_wed;
    private Switch switch_thurs;
    private Switch switch_fri;
    private Switch switch_sat;
    private CheckBox checkBox_weekly;
    private Button button_cancel;
    private int hours;
    private int minutes;
    private long timeLeft;
    public static final String HOURS_NAME =" ";
    public static final String MINUTES_NAME =" ";

    private boolean[] day_of_week;



    /**
    switch_sun.isChecked(),
            switch_mon.isChecked(),
            switch_tues.isChecked(),
            switch_wed.isChecked(),
            switch_thurs.isChecked(),
            switch_fri.isChecked(),
            switch_sat.isChecked()
     **/




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        wireWidgets();
        day_of_week = new boolean[]{
                switch_sun.isChecked(),
                switch_mon.isChecked(),
                switch_tues.isChecked(),
                switch_wed.isChecked(),
                switch_thurs.isChecked(),
                switch_fri.isChecked(),
                switch_sat.isChecked()
        };

        setTime();
        AlarmManager alarm = (AlarmManager)(this.getSystemService(Context.ALARM_SERVICE));
        Intent alarmPage = new Intent(MainActivity.this, AlarmPage.class);
        alarm.setExact(AlarmManager.ELAPSED_REALTIME_WAKEUP,timeLeft, PendingIntent.getBroadcast(this,123,alarmPage,PendingIntent.FLAG_UPDATE_CURRENT));
        alarmPage.putExtra(HOURS_NAME, hours);
        alarmPage.putExtra(MINUTES_NAME, minutes);

        button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlarmManager alarm = (AlarmManager)(MainActivity.this.getSystemService(Context.ALARM_SERVICE));
                Intent alarmPage = new Intent(MainActivity.this, AlarmPage.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 123, alarmPage, PendingIntent.FLAG_UPDATE_CURRENT);
                alarm.cancel(pendingIntent);
            }
            }
        );
    }

    private void setTime() {
        hours = 1;
        minutes = 10;
        //hours = timePicker.getHour();
        //minutes = timePicker.getMinute();
        timeLeft = (long)(hours*3600000 + minutes*60000);
    }

    private void wireWidgets() {
        timePicker = (TimePicker)(findViewById(R.id.timePicker));
        switch_sun = (Switch)(findViewById(R.id.switch_sun));
        switch_mon = (Switch)(findViewById(R.id.switch_mon));
        switch_tues = (Switch)(findViewById(R.id.switch_tues));
        switch_wed = (Switch)(findViewById(R.id.switch_wed));
        switch_thurs = (Switch)(findViewById(R.id.switch_thurs));
        switch_fri = (Switch)(findViewById(R.id.switch_fri));
        switch_sat = (Switch)(findViewById(R.id.switch_sat));
        checkBox_weekly = (CheckBox)(findViewById(R.id.checkBox_weekly));
        button_cancel = (Button)(findViewById(R.id.button_cancel));

    }



}
