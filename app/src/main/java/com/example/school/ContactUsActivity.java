package com.example.school;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class ContactUsActivity extends BaseActivity {
    private ScrollView llLinearLayout;

    @Override
    public void initialize()
    {
        llLinearLayout = (ScrollView) getLayoutInflater().inflate(R.layout.activity_contactus, null);
        llbody1.addView(llLinearLayout, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        tvBaseTitle.setText("Contact Us");
      intilaizeControlls();
    }

    private void intilaizeControlls()
    {

    }


}
