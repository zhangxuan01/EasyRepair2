package com.example.easyrepair3;

import android.app.TabActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TabHost;

import java.util.ArrayList;
import java.util.List;

public class ForumActivity extends TabActivity {
    private MyDatabaseHelper dbHelper;
    private List<Order> order01List = new ArrayList<>();

    private List<Order> order02List = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);
        dbHelper = new MyDatabaseHelper(this,"Easy.db",null,10);
        SharedPreferences pref= PreferenceManager.getDefaultSharedPreferences(this);
        String username = pref.getString("username","");

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from ding where username=?", new String[]{username});
        if (cursor.moveToNext()) {
            do {

                String address = cursor.getString(cursor.getColumnIndex("address"));
                String q_detail = cursor.getString(cursor.getColumnIndex("q_detail"));

                    Order oreder01= new Order(username,address,q_detail);
                    order02List.add(oreder01);



            } while (cursor.moveToNext());
        }
        cursor.close();
        Cursor cursor1 = db.rawQuery("select * from ding where username=? and p_status=? ", new String[]{username,"1"});
        if (cursor1.moveToNext()) {
            do {

                String address = cursor1.getString(cursor.getColumnIndex("address"));
                String q_detail = cursor1.getString(cursor.getColumnIndex("q_detail"));

                Order oreder02= new Order(username,address,q_detail);
                order01List.add(oreder02);



            } while (cursor1.moveToNext());
        }
        cursor1.close();
        //选项卡
        TabHost tabHost = getTabHost();

        TabHost.TabSpec tab01,tab02;


        tab01 = tabHost.newTabSpec("tab1").setIndicator("未完成订单").setContent(R.id.tab01);
        tabHost.addTab(tab01);

        tab02 = tabHost.newTabSpec("tab2").setIndicator("全部订单").setContent(R.id.tab02);
        tabHost.addTab(tab02);
        //listview

        OrderAdapter adapter1 = new OrderAdapter(ForumActivity.this,R.layout.order_item,order01List);
        ListView listView1 = (ListView)findViewById(R.id.list_view1);
        listView1.setAdapter(adapter1);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Order order = order01List.get(position);
                Bundle b1 = new Bundle();
                b1.putString("Username", order.getUsername());
                b1.putString("Address", order.getAddress());
                b1.putString("Q_detail", order.getQ_detail());

                Intent intent = new Intent();
                intent.setClass(ForumActivity.this,OrderManagementActivity.class);
                intent.putExtras(b1);
                startActivity(intent);
            }
        });


        OrderAdapter adapter2 = new OrderAdapter(ForumActivity.this,R.layout.order_item,order02List);
        ListView listView2 = (ListView)findViewById(R.id.list_view2);
        listView2.setAdapter(adapter2);

    }


}
