package com.example.easyrepair3;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class DingdanActivity extends AppCompatActivity {
    private MyDatabaseHelper dbHelper;
    private EditText e_ren,e_dianhua,e_address,e_describe;
    private Button b_tijiao;
    private String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dingdan);
        dbHelper = new MyDatabaseHelper(this,"Easy.db",null,10);
        ImageView iv_back = (ImageView) findViewById(R.id.iv_back);

        e_ren = (EditText) findViewById(R.id.e_ren);

        iv_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               finish();
            }

        });

        e_ren = (EditText) findViewById(R.id.e_ren);
        e_dianhua = (EditText) findViewById(R.id.e_dianhua);
        e_address = (EditText) findViewById(R.id.e_address);
        e_address = (EditText) findViewById(R.id.e_address);
        e_describe = (EditText) findViewById(R.id.e_describe);
        SharedPreferences pref= PreferenceManager.getDefaultSharedPreferences(this);
        username = pref.getString("username","");

        b_tijiao = (Button)findViewById(R.id.b_tijiao);
        b_tijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String linkman = e_ren.getText().toString();
                String link_tel = e_dianhua.getText().toString();
                String address = e_address.getText().toString();
                String q_detail = e_describe.getText().toString();

                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("username",username);
                values.put("linkman",linkman);
                values.put("link_tel",link_tel);
                values.put("address",address);
                values.put("q_detail",q_detail);
                values.put("m_name","");
                values.put("m_tel","");
                values.put("p_status","1");
                values.put("price","");
                values.put("pay_method","支付宝");
                db.insert("ding",null,values); //插入第二条数据
                values.clear();
                Toast.makeText(getApplicationContext(),"订单发布成功",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(DingdanActivity.this,IndexActivity.class);
                startActivity(intent);

            }
        });
    }
}

