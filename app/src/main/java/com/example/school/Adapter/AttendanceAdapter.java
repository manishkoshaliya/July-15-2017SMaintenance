package com.example.school.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.school.R;
import com.example.school.objects.Attendance;

import java.util.ArrayList;

public class AttendanceAdapter extends BaseAdapter {

    ArrayList<Attendance> dataset;
    public Activity context;
    public LayoutInflater inflater;


    public AttendanceAdapter(Activity context, ArrayList<Attendance> data) {
        super();

        this.context = context;

        this.dataset = data;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return dataset.size();
    }

    public void refreshAdapter(ArrayList<Attendance> vecVisitItems) {
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
        TextView name, rollno,rgistrationno,detail;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        ViewHolder holder;
        Attendance attendance = dataset.get(position);
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.adapter_attendance, null);
            holder.name = (TextView) convertView.findViewById(R.id.tvName);
            holder.rollno = (TextView) convertView.findViewById(R.id.tvRollNo);
            holder.rgistrationno = (TextView) convertView.findViewById(R.id.tvRegistartionNo);
            holder.detail = (TextView) convertView.findViewById(R.id.tvDetail);
            convertView.setTag(holder);

        } else
            holder = (ViewHolder) convertView.getTag();
        holder.name.setText(attendance.name);
        holder.rollno.setText(attendance.rollno);
        holder.rgistrationno.setText(attendance.registrationno);
        holder.detail.setText(attendance.detail);

//        String strImageURL = assetCatalogDO.ImagePath;
//        String mainpath = ServiceUrlObj.GET_IMAGE_DATA;
//        strImageURL = strImageURL.replace("..", "/");
//        strImageURL = mainpath + strImageURL;



        return convertView;
    }
}