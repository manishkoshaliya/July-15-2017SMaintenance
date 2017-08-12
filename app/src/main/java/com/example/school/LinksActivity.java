package com.example.school;

import android.os.Bundle;
import android.widget.LinearLayout;

/**
 * Created by inder on 10/8/17.
 */

public class LinksActivity extends BaseActivity {
    private LinearLayout llLink;


    @Override
    public void initialize() {
        llLink = (LinearLayout) getLayoutInflater().inflate(R.layout.activity_link, null);
        llbody1.addView(llLink,
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        setTitleBase("Links");
    }
}
