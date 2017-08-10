package com.example.school;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private LinearLayout lllinearLayout;
    private Button       btn;
    @Override
    public void initialize()
    {
        lllinearLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.activity_login, null);
        llbody1.addView(lllinearLayout, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        initializeControlls();
    }

    private void initializeControlls()
    {
        btn=(Button)findViewById(R.id.btnLogin);
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        try {
            android.support.v7.app.ActionBar actionBar = getSupportActionBar();
            if (actionBar != null)
                actionBar.hide();

        } catch (Exception e) {

        }
        btn.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        if(view.getId()==R.id.btnLogin)
        {
            Intent intent=new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
        }
    }
}
