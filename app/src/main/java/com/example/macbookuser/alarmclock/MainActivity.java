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
import android.widget.Toast;

import java.util.Calendar;


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
    private Button button_save;
    private Button button_alarmSounds;
    private int hours;
    private int minutes;
    private int alarmTime;
    private int hoursNow;
    private int minutesNow;
    private int timeNow;
    private long timeLeft;
    private int songNumber;
    public static final String HOURS_NAME =" ";
    public static final String MINUTES_NAME =" ";
    public static final String ALARM_CHOICE = "";
    public static final int REQUEST_SONG=0;
    private int alarmNumber;


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

        Calendar c = Calendar.getInstance();
        int minutesNow = c.get(Calendar.MINUTE);
        int hoursNow = c.get(Calendar.HOUR);
        setTime();


        button_save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //Context context = MainActivity.this;
               //PendingIntent.FLAG_UPDATE_CURRENT
               //Intent alarmPage = new Intent(MainActivity.this, AlarmPage.class);
                AlarmManager alarm = (AlarmManager)(MainActivity.this.getSystemService(Context.ALARM_SERVICE));
                Intent intent = new Intent(MainActivity.this, myReceiver.class);
                intent.putExtra(HOURS_NAME, hours);
            intent.putExtra(MINUTES_NAME, minutes);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 123, intent,PendingIntent.FLAG_UPDATE_CURRENT);
                //alarm.setExact(AlarmManager.RTC_WAKEUP,timeLeft, PendingIntent.getBroadcast(MainActivity.this,123,alarmPage,PendingIntent.FLAG_UPDATE_CURRENT));
                alarm.setExact(AlarmManager.RTC_WAKEUP,timeLeft, pendingIntent);

                Toast.makeText(MainActivity.this, "Your alarm has been saved", Toast.LENGTH_SHORT).show();

                /**
                 * public class AlarmReceiver extends BroadcastReceiver {
                 public void onReceive(Context context, Intent intent){
                 Toast.makeText(context, "Recieved!!", Toast.LENGTH_LONG).show();

                 Activity act = new Activity();
                 act.startActivity(intent);
                 }
                 }
                 **/


            }
                                       }
        );

        button_alarmSounds.setOnClickListener(new View.OnClickListener(){
                                                  @Override
                                                  public void onClick(View view) {
                                                      Intent alarmSounds = new Intent(MainActivity.this, AlarmSounds.class);

                                                      alarmSounds.putExtra(ALARM_CHOICE, alarmNumber);
                                                      startActivityForResult(alarmSounds, REQUEST_SONG);

                                                  }
                                              }
        );




        button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlarmManager alarm = (AlarmManager)(MainActivity.this.getSystemService(Context.ALARM_SERVICE));
                Intent alarmPage = new Intent(MainActivity.this, AlarmPage.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 123, alarmPage, PendingIntent.FLAG_UPDATE_CURRENT);
                alarm.cancel(pendingIntent);
                Toast.makeText(MainActivity.this, "Your alarm has been cancelled", Toast.LENGTH_SHORT).show();
            }
            }
        );
    }

@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
    if (resultCode== RESULT_OK && requestCode == REQUEST_SONG){
        songNumber = data.getIntExtra(ALARM_CHOICE, 1);
    }
}

    private void setTime() {
       // hours = timePicker.getHour();
       // minutes = timePicker.getMinute();
       // alarmTime = (hours*3600000 + minutes*60000);
       // timeNow = (hoursNow*3600000 + minutesNow*60000);
       // timeLeft = (long)(alarmTime - timeNow);
        timeLeft= (long)(10000);

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
        button_save = (Button) (findViewById(R.id.button_save));
        button_alarmSounds = (Button)(findViewById(R.id.button_alarmSounds));

    }



}
