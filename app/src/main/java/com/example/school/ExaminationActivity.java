package com.example.school;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.school.Adapter.ExamAdapter;
import com.example.school.objects.ExamDO;

import java.util.ArrayList;

public class ExaminationActivity extends BaseActivity {
    private LinearLayout llLinearLayout;
    private ListView listView;
    private ExamAdapter adapter;
    private ArrayList<ExamDO> examDOs;

    @Override
    public void initialize()
    {
        llLinearLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.activity_examination, null);
        llbody1.addView(llLinearLayout, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        tvBaseTitle.setText("Fee");
      intilaizeControlls();
    }

    private void intilaizeControlls()
    {
         listView=(ListView)llLinearLayout.findViewById(R.id.lvListView);
         adapter=new ExamAdapter(ExaminationActivity.this,getData());
        listView.setAdapter(adapter);

    }



private  ArrayList<ExamDO> getData()
{
    examDOs=new ArrayList<>();

    ExamDO examDO1=new ExamDO();
    examDO1.examName="Hindi";
    examDOs.add(examDO1);


    ExamDO examDO2=new ExamDO();
    examDO2.examName="English";
    examDOs.add(examDO2);

    return examDOs;
}

}
