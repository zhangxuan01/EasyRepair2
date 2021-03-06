package com.example.easyrepair3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2018/5/4.
 */

public class Blog01Adapter extends ArrayAdapter<Blog01> {
    private  int resourceId;
    public Blog01Adapter( Context context,int textViewResource,  List<Blog01> objects) {
        super(context, textViewResource, objects);
        resourceId = textViewResource;
    }

    @NonNull
    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        Blog01 blog01 = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.blog01Name = (TextView) view.findViewById(R.id.blog01_name);
            viewHolder.blog01Content = (TextView) view.findViewById(R.id.blog01_content);
            view.setTag(viewHolder);
        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.blog01Name.setText(blog01.getName());
        viewHolder.blog01Content.setText(blog01.getContent());
        return view;
    }
    class ViewHolder{
        TextView blog01Name;
        TextView blog01Content;
    }
}


