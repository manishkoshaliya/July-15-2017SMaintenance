package com.example.school;

import android.view.ViewGroup;
import android.widget.LinearLayout;

public class FeesActivity extends BaseActivity {
    private LinearLayout llLinearLayout;

    @Override
    public void initialize()
    {
        llLinearLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.activity_fees, null);
        llbody1.addView(llLinearLayout, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        tvBaseTitle.setText("Fee");
      intilaizeControlls();
    }

    private void intilaizeControlls()
    {

    }


}
