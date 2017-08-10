package com.example.school;

import android.view.ViewGroup;
import android.widget.LinearLayout;

public class TimeTableActivity extends BaseActivity {
    private LinearLayout llLinearLayout;
    @Override
    public void initialize()
    {
        llLinearLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.activity_timetable, null);
        llbody1.addView(llLinearLayout, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        tvBaseTitle.setText("TimeTable");
      intilaizeControlls();
    }

    private void intilaizeControlls()
    {

    }


}
