package com.yyt.today;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.necer.ncalendar.calendar.NCalendar;
import com.necer.ncalendar.listener.OnCalendarChangeListener;

import org.joda.time.DateTime;

public class AllEventActivity extends AppCompatActivity {
    private NCalendar mNCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_event);
        getSupportActionBar().hide();

        FloatingActionButton fab = findViewById(R.id.edit);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplication(), EditActivity.class));
            }
        });

        mNCalendar = findViewById(R.id.ncalendar);
        mNCalendar.setOnCalendarChangeListener(new OnCalendarChangeListener() {
            @Override
            public void onClickCalendar(DateTime dateTime) {
                //日历点击回调
            }

            @Override
            public void onCalendarPageChanged(DateTime dateTime) {
                //日历翻页回调
            }
        });
        //跳转日期
//        mNCalendar.setDate(int year, int month, int day);
        //回到今日
        mNCalendar.toToday();

        RoundCornerProgressBar progress = findViewById(R.id.progress);
    }
}
