package com.example.school;

import android.view.ViewGroup;
import android.widget.LinearLayout;

public class ContactUsActivity extends BaseActivity {
    private LinearLayout llLinearLayout;

    @Override
    public void initialize()
    {
        llLinearLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.activity_contactus, null);
        llbody1.addView(llLinearLayout, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        tvBaseTitle.setText("Contact Us");
      intilaizeControlls();
    }

    private void intilaizeControlls()
    {

    }


}
