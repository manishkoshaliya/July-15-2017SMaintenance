package com.example.school;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.school.Adapter.PtmAdapter;
import com.example.school.objects.PtmDO;

import java.util.ArrayList;

public class PtmActivity extends BaseActivity {
    private LinearLayout llLinearLayout;
    private ListView   listView;
    private PtmAdapter adapter;
    private ArrayList<PtmDO> arrayList;

    @Override
    public void initialize()
    {
        llLinearLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.activity_ptm, null);
        llbody1.addView(llLinearLayout, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        tvBaseTitle.setText("Fee");
      intilaizeControlls();
    }

    private void intilaizeControlls()
    {

        listView=(ListView)findViewById(R.id.lvListView);
        adapter =new PtmAdapter(PtmActivity.this,getData());
        listView.setAdapter(adapter);
    }

    private ArrayList<PtmDO> getData()
    {
        arrayList=new ArrayList<PtmDO>();

        PtmDO ptmDO1=new PtmDO();
        ptmDO1.psubjectName="Hindi";
        arrayList.add(ptmDO1);

        PtmDO ptmDO2=new PtmDO();
        ptmDO1.psubjectName="English";
        arrayList.add(ptmDO2);

        return arrayList;
    }

}
