package com.example.macbookuser.alarmclock;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Macbookuser on 10/19/16.
 */
public class AlarmSounds extends AppCompatActivity {


    private MediaPlayer[] alarms;
    private MediaPlayer circleOfLife;
    private MediaPlayer minion;
    private Button button_circle;
    private Button button_minion;
    private String alarmChoice;
    public static final String ALARM_CHOICE = "";
    private int numberChoice;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarmsounds);
        loadMediafiles();
        wireWidgets();
        alarms = new MediaPlayer[] {circleOfLife, minion};
        Intent alarmSounds = getIntent();

        button_circle.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                numberChoice =1;
                Intent alarmSounds = getIntent();
                alarmSounds.putExtra(ALARM_CHOICE, numberChoice);
                setResult(RESULT_OK, alarmSounds);


            }
                                         }
        );

        button_minion.setOnClickListener(new View.OnClickListener(){
                                             @Override
                                             public void onClick(View view)
                                             {
                                                 numberChoice =2;
                                                 Intent alarmSounds = getIntent();
                                                 alarmSounds.putExtra(ALARM_CHOICE, numberChoice);
                                                 setResult(RESULT_OK, alarmSounds);

                                             }
                                         }
        );

    }

    private void wireWidgets() {
        button_circle = (Button)(findViewById(R.id.button_circle));
        button_minion = (Button)(findViewById(R.id.button_minion));
    }

    private void loadMediafiles() {
        circleOfLife = MediaPlayer.create(this,R.raw.circle_of_life);
        minion = MediaPlayer.create(this, R.raw.minion);
    }
}
