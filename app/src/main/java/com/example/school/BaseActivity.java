package com.example.school;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.SystemClock;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.school.Adapter.DrawerExpandableListAdapter;
import com.example.school.objects.Items;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by Ashwani on 4/25/2017.
 */
public abstract class BaseActivity extends AppCompatActivity {

    public DrawerLayout drawerLayout;
    public LayoutInflater inflater;
    public DrawerExpandableListAdapter drawerExpandableListAdapter;
    public Toolbar toolbar;
    public TextView tvName, tvTime, tvDate, tvAlarm,tv_email;
    private ExpandableListView expandableListView;
    ArrayList<Items> listHeader;
    private LinkedHashMap<Items, ArrayList<Items>> linkedHashMap;

    LinearLayout llbody1;

    private Context context;
    public AlertDialog alertDialog;
    private Dialog dialog;
    public AlertDialog.Builder alertBuilder;
    private Handler customHandler = new Handler();
    long timeInMilliseconds = 0L;
    long timeSwapBuff = 0L;
    long updatedTime = 0L;
    public  DecimalFormat ddFormate;
    private long startTime = 0L;
    private BCR bcr;
    public String asText;
    public Chronometer tvBaseCheckinTime;
    public ImageView chronometerimage,ivBaseNotifi,ivBaseProfile,profileicon;

    public TextView tvBaseTitle;
    public TextView tvRefresh;

    public static float px;

    private int groupPos11;




    public static HashMap<String, String> hmStatusIds;

    public static HashMap<String, String> hmStatus;

    public class BCR extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

                finish();

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        unregisterReceiver(bcr);

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        inflater = this.getLayoutInflater();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        View view = getLayoutInflater().inflate(R.layout.base_main_topbar, null);
        tvBaseTitle              = (TextView) view.findViewById(R.id.tvBaseTitle);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        toolbar.addView(view);
        initNavigationDrawer();
        initialize();


    }

    public void initNavigationDrawer() {
        expandableListView = (ExpandableListView) findViewById(R.id.expndablelistview);


        NavigationView navigationView = (NavigationView) findViewById(R.id.na_view);
        llbody1 = (LinearLayout) findViewById(R.id.llBody11);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

      /*  profileicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BaseActivity.this,ProfileActivity.class);
                startActivity(intent);
            }
        });*/
        prepareListData();
        drawerExpandableListAdapter = new DrawerExpandableListAdapter(BaseActivity.this, linkedHashMap);
        expandableListView.setAdapter(drawerExpandableListAdapter);

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                if (i != 3) {
                    moveToNextActivity(i, 0);
                }
                return false;
            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {

                moveToNextActivity(i, i1);

                return false;
            }
        });
        View header = navigationView.getHeaderView(0);
        tv_email = (TextView) header.findViewById(R.id.tv_email);
        profileicon = (ImageView) header.findViewById(R.id.profileicon);
       // tv_email.setText(preference.getStringFromPreference(Preference.NAME,""));
        header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             /*   Intent intent = new Intent(BaseActivity.this, ProfileActivity.class);
                uploadDatabaseIntoSDCARD(true);
                showToast("Upload Database");
                startActivity(intent);*/
            }
        });
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerClosed(View v) {
                super.onDrawerClosed(v);
            }

            @Override
            public void onDrawerOpened(View v) {
                super.onDrawerOpened(v);
            }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        drawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    private void prepareListData() {
        listHeader = new ArrayList<Items>();

        listHeader.add(new Items("Campus Hostel", R.drawable.icon_user));
        listHeader.add(new Items("Girls Pg", R.drawable.icon_user));
        listHeader.add(new Items("Boys Pg", R.drawable.icon_user));

        linkedHashMap = new LinkedHashMap<Items, ArrayList<Items>>();
        linkedHashMap.put(new Items("Dashboard", R.drawable.icon_user), null);
        linkedHashMap.put(new Items("Attendance", R.drawable.icon_user), null);
        linkedHashMap.put(new Items("Timetable", R.drawable.icon_user), null);

        linkedHashMap.put(new Items("Hostel", R.drawable.icon_user), listHeader);
        linkedHashMap.put(new Items("Notification", R.drawable.icon_user), null);
        linkedHashMap.put(new Items("Settings", R.drawable.icon_user), null);
        linkedHashMap.put(new Items("Help", R.drawable.icon_user), null);
        linkedHashMap.put(new Items("Logout", R.drawable.icon_user), null);
    }

    private void moveToNextActivity(final int groupPos, final int childPos) {
        drawerLayout.closeDrawer(Gravity.LEFT);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;

                groupPos11 = groupPos;
                if (groupPos == 0) {

                    if (!(BaseActivity.this instanceof MainActivity)) {

                         //   Intent obIntent1 = new Intent();
                          //  obIntent1.setAction(AppConstants.ACTION_DASHBOARD);
                          //  sendBroadcast(obIntent1);
                            intent = new Intent(BaseActivity.this, MainActivity.class);
                            startActivity(intent);


                    }

                } else if (groupPos == 1) {

                    if (!(BaseActivity.this instanceof MainActivity)) {

                      //      Intent obIntent1 = new Intent();
                      //      obIntent1.setAction(AppConstants.ACTION_JOURNEYPLAN);
                       //     sendBroadcast(obIntent1);
                            intent = new Intent(BaseActivity.this, MainActivity.class);
                            startActivity(intent);
                        }


                } else if (groupPos == 2) {

                    if (!(BaseActivity.this instanceof MainActivity)) {
                        intent = new Intent(BaseActivity.this, MainActivity.class);
                        startActivity(intent);

                    }
                } else if (groupPos == 5) {
                    if (!(BaseActivity.this instanceof MainActivity)) {
                        intent = new Intent(BaseActivity.this, MainActivity.class);
                        startActivity(intent);

                    }

                } else if (groupPos == 6) {
                    if (!(BaseActivity.this instanceof MainActivity)) {
                        intent = new Intent(BaseActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                } else if (groupPos == 7) {
                   // showCustomDialog1(BaseActivity.this, "Alert!","Do You Want Logout?", "YES", "NO", "logout");

                } else if (groupPos == 3 && childPos == 0) {
                    if (!(BaseActivity.this instanceof MainActivity)) {
                        intent = new Intent(BaseActivity.this, MainActivity.class);
                        startActivity(intent);

                    }
                } else if (groupPos == 3 && childPos == 1) {
                    if (!(BaseActivity.this instanceof MainActivity)) {

                        intent = new Intent(BaseActivity.this, MainActivity.class);
                        startActivity(intent);

                    }
                } else if (groupPos == 3 && childPos == 2) {
                    if (!(BaseActivity.this instanceof MainActivity)) {
                        intent = new Intent(BaseActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                }
            }
        }, 500);
    }

    public void setTitleBase(String str) {
        if (tvBaseTitle != null && !TextUtils.isEmpty(str))
            tvBaseTitle.setText(str);
        else tvBaseTitle.setText(str);
    }

    public abstract void initialize();
}
