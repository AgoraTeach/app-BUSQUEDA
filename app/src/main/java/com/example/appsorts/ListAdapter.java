package com.example.appsorts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<ItemList> {
    public ListAdapter(Context context, ArrayList<ItemList> Lista) {
        super(context, 0, Lista);
    }

    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        return initView(position,convertView,parent);
    }

    @Override
    public View getDropDownView(int position,  View convertView, ViewGroup parent) {
        return initView(position,convertView,parent);
    }

    public View initView (int position, View convertView, ViewGroup parent){
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.items,parent,false);

        }

        TextView dato = (TextView) convertView.findViewById(R.id.textView);

        ItemList itemdata = getItem(position);
        if (itemdata != null){
            dato.setText(itemdata.getApellidos());
        }
        return  convertView;
    }
}
