package com.example.school;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;

import com.example.school.Adapter.AttendanceAdapter;
import com.example.school.objects.Attendance;

import java.util.ArrayList;

public class AttendanceActivity extends BaseActivity {
    private LinearLayout llLinearLayout;
    private AttendanceAdapter adpater;
    private ArrayList<Attendance> arrayList;
    private ListView listView;
    @Override
    public void initialize()
    {
        llLinearLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.activity_attendance, null);
        llbody1.addView(llLinearLayout, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        tvBaseTitle.setText("Attendance");
        loadData();
      intilaizeControlls();
    }

    private void intilaizeControlls()
    {
        listView=(ListView)findViewById(R.id.listview);

        adpater=new AttendanceAdapter(AttendanceActivity.this,arrayList);
        listView.setAdapter(adpater);

    }

    private void loadData()
    {
        arrayList= new ArrayList<Attendance>();

        Attendance attendance1=new Attendance();
        attendance1.rollno ="1";
        attendance1.registrationno   ="CA12345";
        attendance1.name   ="Ameet Singh";
        attendance1.detail ="XYZ";

        arrayList.add(attendance1);

        Attendance attendance2=new Attendance();
        attendance2.rollno ="2";
        attendance2.registrationno   ="CA12346";
        attendance2.name   ="Ameet Singh";
        attendance2.detail ="XYZ";

        arrayList.add(attendance2);


        Attendance attendance3=new Attendance();
        attendance3.rollno ="3";
        attendance3.registrationno   ="CA12347";
        attendance3.name   ="Ameet Singh";
        attendance3.detail ="XYZ";

        arrayList.add(attendance3);

    }

}
