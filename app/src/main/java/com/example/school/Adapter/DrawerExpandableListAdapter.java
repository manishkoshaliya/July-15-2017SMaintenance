package com.example.school.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.school.R;
import com.example.school.objects.Items;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class DrawerExpandableListAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private ArrayList<Items> _items_main;
    private int isAboutClick = 0;
    private LinkedHashMap<Items,ArrayList<Items>> hmItems;
    private Set keys;
    Iterator itr;

    public DrawerExpandableListAdapter(Context _context, LinkedHashMap<Items,ArrayList<Items>> hmItems) {
        this._context = _context;
        this.hmItems = hmItems;
        keys = hmItems.keySet();
        itr = keys.iterator();
//        for (int i = 0; i < keys.size(); i++)
//        {
//            _items.add(keys.toArray()));
//        }
        _items_main = new ArrayList<Items>();
        while (itr.hasNext())
        {
            Items item = (Items) itr.next();
            _items_main.add(item);
        }
    }

    private class ViewHolderGroup {
        TextView itemName;
        ImageView itemIcon,txt_plusminus;
    }
    private class ViewHolderChild {
        TextView itemName;
        ImageView itemIcon;
    }
    @Override
    public int getGroupCount() {
        if(hmItems != null && hmItems.size() > 0)
            return hmItems.size();
        else return 0;
    }

    @Override
    public int getChildrenCount(int i) {

        if(hmItems.get(_items_main.get(i)) != null && hmItems.get(_items_main.get(i)).size() > 0)
        {
            return hmItems.get(_items_main.get(i)).size();
        }
        else return 0;
    }

    @Override
    public Object getGroup(int i) {
        return _items_main.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {

        return hmItems.get(_items_main.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View convertView, ViewGroup viewGroup) {
        ViewHolderGroup holder = null;

        LayoutInflater mInflater = (LayoutInflater) _context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.drawer_list_item, null);
            holder = new ViewHolderGroup();
            holder.itemName = (TextView) convertView
                    .findViewById(R.id.item_name_txtview);
            holder.itemIcon = (ImageView) convertView
                    .findViewById(R.id.item_icon_imgview);

            holder.txt_plusminus = (ImageView) convertView
                    .findViewById(R.id.plus_txt);

            convertView.setTag(holder);



        } else {
            holder = (ViewHolderGroup) convertView.getTag();
        }

        Items item = (Items) getGroup(i);
        holder.itemName.setText(item.getItemName());

        holder.itemIcon.setImageResource((int) item.getIconId());


        if(i==3) {

            holder.txt_plusminus.setVisibility(View.VISIBLE);

            if (b) {
                holder.txt_plusminus.setImageResource(R.drawable.down_arrownew);
            } else {
                holder.txt_plusminus.setImageResource(R.drawable.right_arrownew);
            }

        }

        holder.itemIcon.setVisibility(View.VISIBLE);
        holder.txt_plusminus.setVisibility(View.VISIBLE);
        return convertView;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View convertView, ViewGroup viewGroup) {
        ViewHolderChild holder = null;

        LayoutInflater mInflater = (LayoutInflater) _context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.drawer_list_item1, null);
            holder = new ViewHolderChild();
            holder.itemName = (TextView) convertView
                    .findViewById(R.id.item_name_txtview);
               holder.itemIcon = (ImageView) convertView
                  .findViewById(R.id.item_icon_imgview);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolderChild) convertView.getTag();
        }
        Items item = (Items) getChild(i,i1);

        holder.itemName.setText(item.getItemName());
        holder.itemIcon.setImageResource((int) item.getIconId());


        //    holder.itemIcon.setVisibility(View.INVISIBLE);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}

