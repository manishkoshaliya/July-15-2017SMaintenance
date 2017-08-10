package com.example.school;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private ScrollView llscrollview;
    private ImageView ivBaseProfile, ivAttendnce, ivTimetable, ivHostel;
    private ImageView ivContactUs, ivFees, ivFaculty;
    private ImageView ivGallery, ivExams, ivPtm, ivStatics;


    @Override
    public void initialize() {
        llscrollview = (ScrollView) getLayoutInflater().inflate(R.layout.activity_home, null);
        llbody1.addView(llscrollview, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        tvBaseTitle.setText("Home");

        intilaizeControlls();
    }

    private void intilaizeControlls() {
        ivBaseProfile = (ImageView) findViewById(R.id.ivProfile);
        ivAttendnce = (ImageView) findViewById(R.id.ivAttendnce);
        ivTimetable = (ImageView) findViewById(R.id.ivTimetable);
        ivHostel = (ImageView) findViewById(R.id.ivHostel);

        ivContactUs = (ImageView) findViewById(R.id.ivContactUs);
        ivFees = (ImageView) findViewById(R.id.ivFees);
        ivFaculty = (ImageView) findViewById(R.id.ivFaculty);

        ivGallery = (ImageView) findViewById(R.id.ivGallery);
        ivExams = (ImageView) findViewById(R.id.ivExams);
        ivPtm = (ImageView) findViewById(R.id.ivPtm);
        ivStatics = (ImageView) findViewById(R.id.ivStatics);

        ivBaseProfile.setOnClickListener(this);
        ivAttendnce.setOnClickListener(this);
        ivTimetable.setOnClickListener(this);
        ivHostel.setOnClickListener(this);

        ivContactUs.setOnClickListgener(this);
        ivFees.setOnClickListener(this);
        ivFaculty.setOnClickListener(this);

        ivGallery.setOnClickListener(this);
        ivExams.setOnClickListener(this);
        ivPtm.setOnClickListener(this);
        ivStatics.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        if (v.getId() == R.id.ivProfile) {
            intent = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.ivAttendnce) {
            intent = new Intent(MainActivity.this, AttendanceActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.ivTimetable) {
            intent = new Intent(MainActivity.this, TimeTableActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.ivHostel) {
            intent = new Intent(MainActivity.this, HostelActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.ivContactUs) {
            intent = new Intent(MainActivity.this, ContactUsActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.ivFees) {
            intent = new Intent(MainActivity.this, FeesActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.ivFaculty) {
            intent = new Intent(MainActivity.this, FacultyActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.ivGallery) {
            intent = new Intent(MainActivity.this, GalleryActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.ivExams) {
            intent = new Intent(MainActivity.this, ExaminationActivity.class);
            startActivity(intent);
        }else if (v.getId() == R.id.ivPtm) {
            intent = new Intent(MainActivity.this, PtmActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.ivStatics) {
            intent = new Intent(MainActivity.this, StaticsActivity.class);
            startActivity(intent);
        }

    }
}
