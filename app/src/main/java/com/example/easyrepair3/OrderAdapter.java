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
 * Created by Administrator on 2018/5/5.
 */

public class OrderAdapter extends ArrayAdapter<Order> {
    private  int resourceId;
    public OrderAdapter( Context context,int textViewResource,  List<Order> objects) {
        super(context, textViewResource, objects);
        resourceId = textViewResource;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Order order = getItem(position);
        View view;   //Integer id, String username,String address,String q_detail
        ViewHolder viewHolder;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder = new ViewHolder();

            viewHolder.orderusername = (TextView) view.findViewById(R.id.order_name1);
            viewHolder.orderaddress = (TextView) view.findViewById(R.id.order_address1);
            viewHolder.q_detail = (TextView) view.findViewById(R.id.order_q_detail1);
            view.setTag(viewHolder);
        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }


        viewHolder.orderusername.setText(order.getUsername());
        viewHolder.orderaddress.setText(order.getAddress());
        viewHolder.q_detail.setText(order.getQ_detail());
        return view;
    }
    class ViewHolder{

        TextView orderusername;
        TextView orderaddress;
        TextView q_detail;
    }
}
