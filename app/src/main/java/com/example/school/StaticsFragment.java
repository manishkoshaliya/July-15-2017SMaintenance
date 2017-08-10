package com.example.school;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;


@SuppressLint("ValidFragment")
public class StaticsFragment extends Fragment
{

    BarChart chart ;
    ArrayList<BarEntry> BARENTRY ;
    ArrayList<String> BarEntryLabels ;
    BarDataSet Bardataset ;
    BarData BARDATA ;

    private View llCustomerView;
    private int pos = 0;

    public StaticsFragment()
    {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        llCustomerView = inflater.inflate(R.layout.fragment_statics, container, false);



        initializeControls();


        return llCustomerView;
    }

    private void initializeControls()
    {

        BARENTRY = new ArrayList<>();
        BarEntryLabels = new ArrayList<String>();

        AddValuesToBARENTRY();

        AddValuesToBarEntryLabels();

        Bardataset = new BarDataSet(BARENTRY, "");

        BARDATA = new BarData(BarEntryLabels, Bardataset);

        Bardataset.setColors(ColorTemplate.COLORFUL_COLORS);

        chart.setData(BARDATA);

       // chart.animateY(3000);
    }

    public void AddValuesToBARENTRY(){

        BARENTRY.add(new BarEntry(2f, 0));
        BARENTRY.add(new BarEntry(4f, 1));
        BARENTRY.add(new BarEntry(6f, 2));
        BARENTRY.add(new BarEntry(8f, 3));
        BARENTRY.add(new BarEntry(7f, 4));


    }

    public void AddValuesToBarEntryLabels(){

        BarEntryLabels.add("Hindi");
        BarEntryLabels.add("English");
        BarEntryLabels.add("Maths");
        BarEntryLabels.add("Science");
        BarEntryLabels.add("History");


    }

    @Override
    public void onStart()
    {
        super.onStart();
    }


    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
    }

    public void setPos(int pos)
    {
        this.pos = pos;
    }

}
