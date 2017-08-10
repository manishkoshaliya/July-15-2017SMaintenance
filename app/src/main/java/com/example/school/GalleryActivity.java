package com.example.school;

import android.view.ViewGroup;
import android.widget.ScrollView;

public class GalleryActivity extends BaseActivity {
    private ScrollView svLinearLayout;

    @Override
    public void initialize()
    {
        svLinearLayout = (ScrollView) getLayoutInflater().inflate(R.layout.activity_gallery, null);
        llbody1.addView(svLinearLayout, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        tvBaseTitle.setText("Gallery");
      intilaizeControlls();
    }

    private void intilaizeControlls()
    {

    }


}
