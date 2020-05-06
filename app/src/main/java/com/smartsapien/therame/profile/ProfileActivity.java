package com.smartsapien.therame.profile;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.smartsapien.therame.R;

import butterknife.BindView;
import butterknife.ButterKnife;
public class ProfileActivity extends AppCompatActivity {
    @BindView(R.id.calendar)CalendarView calendarView;
   // @BindView(R.id.date_view)TextView date_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        // Add Listener in calendar
        calendarView.setOnDateChangeListener(
                        new CalendarView
                                .OnDateChangeListener() {
                            @Override
                            // In this Listener have one method
                            // and in this method we will
                            // get the value of DAYS, MONTH, YEARS
                            public void onSelectedDayChange(
                                    @NonNull CalendarView view,
                                    int year,
                                    int month,
                                    int dayOfMonth)
                            {
                                // Store the value of date with
                                // format in String type Variable
                                // Add 1 in month because month
                                // index start with 0
                                String Date
                                        = dayOfMonth + "-"
                                        + (month + 1) + "-" + year;
                                // set this date in TextView for Display
                                //date_view.setText(Date);
                            }
                        });

    }
}

