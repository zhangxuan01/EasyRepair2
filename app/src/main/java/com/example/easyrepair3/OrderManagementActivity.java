package com.example.easyrepair3;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class OrderManagementActivity extends AppCompatActivity {
    private MyDatabaseHelper dbHelper;
    private String Username;
    private String Address;
    private String Q_detail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_management);
        dbHelper = new MyDatabaseHelper(this,"Easy.db",null,10);
        ImageView iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }

        });

        Bundle bundle = getIntent().getExtras();
        Username = bundle.getString("Username");
        Address = bundle.getString("Address");
        Q_detail = bundle.getString("Q_detail");
        TextView order_Username = (TextView) findViewById(R.id.order_name1);
        order_Username.setText(Username);
        TextView order_Address = (TextView) findViewById(R.id.order_address1);
        order_Address.setText(Address);
        TextView order_Q_detail = (TextView) findViewById(R.id.order_q_detail1);
        order_Q_detail.setText(Q_detail);
        TextView linkman1 = (TextView) findViewById(R.id.order_linkman1);
        TextView link_tel1 = (TextView) findViewById(R.id.order_linkman_tel1);
        TextView m_name1 = (TextView) findViewById(R.id.order_m_name1);
        TextView m_tel1 = (TextView) findViewById(R.id.order_m_tel1);
        TextView price1 = (TextView) findViewById(R.id.order_price);
        TextView pay_method1 = (TextView) findViewById(R.id.order_pay_method);
        Button delete_order = (Button) findViewById(R.id.delete_order);



        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from ding where username=? and address=? and q_detail=? and p_status=?",
                new String[]{Username,Address,Q_detail,"1"});
        if (cursor.moveToNext()) {
            do {
                String order_id = cursor.getString(cursor.getColumnIndex("id"));
                String linkman = cursor.getString(cursor.getColumnIndex("linkman"));
                String link_tel = cursor.getString(cursor.getColumnIndex("link_tel"));
                String m_name = cursor.getString(cursor.getColumnIndex("m_name"));
                String m_tel = cursor.getString(cursor.getColumnIndex("m_tel"));
                String pay_method = cursor.getString(cursor.getColumnIndex("pay_method"));
                String price = cursor.getString(cursor.getColumnIndex("price"));

                linkman1.setText(linkman);
                link_tel1.setText(link_tel);
                m_name1.setText(m_name);
                m_tel1.setText(m_tel);
                pay_method1.setText(pay_method);
                price1.setText(price);




            } while (cursor.moveToNext());
        }
        cursor.close();
        delete_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                Intent intent = new Intent();
                intent.setClass(OrderManagementActivity.this,IndexActivity.class);
                startActivity(intent);

                db.delete("ding","username=? and address=? and q_detail=? and p_status=?",new String[]{Username,Address,Q_detail,"1"});
                Toast.makeText(getApplicationContext(),"删除成功",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
