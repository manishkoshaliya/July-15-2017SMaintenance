package com.example.school;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class ProfileActivity extends BaseActivity {
    private LinearLayout llLinearLayout;

    @Override
    public void initialize()
    {
        llLinearLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.activity_profile, null);
        llbody1.addView(llLinearLayout, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        tvBaseTitle.setText("Profile");
      intilaizeControlls();
    }

    private void intilaizeControlls()
    {

    }


}
