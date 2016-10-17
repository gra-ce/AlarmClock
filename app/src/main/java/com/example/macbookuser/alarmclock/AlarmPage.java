package com.example.macbookuser.alarmclock;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Macbookuser on 10/11/16.
 */
public class AlarmPage extends AppCompatActivity {

    private int hours;
    private int minutes;
    private TextView textView_time;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarmpage);

        Intent alarmPage = getIntent();
        hours = alarmPage.getIntExtra(MainActivity.HOURS_NAME,0);
        minutes = alarmPage.getIntExtra(MainActivity.MINUTES_NAME,0);

        textView_time = (TextView) findViewById(R.id.textView_time);
        textView_time.setText(hours + ":" + minutes);




    }
}
