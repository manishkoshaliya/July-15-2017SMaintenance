package com.example.school.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.school.R;
import com.example.school.objects.ExamDO;
import com.example.school.objects.PtmDO;

import java.util.ArrayList;

public class PtmAdapter extends BaseAdapter {

    ArrayList<PtmDO> dataset;
    public Activity context;
    public LayoutInflater inflater;


    public PtmAdapter(Activity context, ArrayList<PtmDO> data) {
        super();

        this.context = context;
        this.dataset = data;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        // TODO Auto-generated method stub

        if(dataset !=null && dataset.size() >0)
            return dataset.size();
        else
            return 0;
    }

    public void refreshAdapter(ArrayList<PtmDO> vecVisitItems) {
        this.dataset = vecVisitItems;
        notifyDataSetChanged();
    }
    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }


    public static class ViewHolder {
        TextView name;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        ViewHolder holder;
        PtmDO ptmDO = dataset.get(position);
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.adapter_ptm, null);
            holder.name = (TextView) convertView.findViewById(R.id.tvPSubjectName);
         //   holder.rollno = (TextView) convertView.findViewById(R.id.tvRollNo);
         //   holder.rgistrationno = (TextView) convertView.findViewById(R.id.tvRegistartionNo);
         //   holder.detail = (TextView) convertView.findViewById(R.id.tvDetail);
            convertView.setTag(holder);

        } else
            holder = (ViewHolder) convertView.getTag();
        holder.name.setText(ptmDO.psubjectName);
     //   holder.rollno.setText(attendance.rollno);
    //    holder.rgistrationno.setText(attendance.registrationno);
     //   holder.detail.setText(attendance.detail);

//        String strImageURL = assetCatalogDO.ImagePath;
//        String mainpath = ServiceUrlObj.GET_IMAGE_DATA;
//        strImageURL = strImageURL.replace("..", "/");
//        strImageURL = mainpath + strImageURL;



        return convertView;
    }
}