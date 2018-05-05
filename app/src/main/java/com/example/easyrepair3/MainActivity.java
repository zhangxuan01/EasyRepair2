package com.example.easyrepair3;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private MyDatabaseHelper dbHelper;
    private Button add_data;
    private Button update_data;
    private Button delete_data;
    private Button query_data;
    private Button cre_user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new MyDatabaseHelper(this,"Easy.db",null,9);
        cre_user = (Button)findViewById(R.id.cre_user);
        add_data = (Button) findViewById(R.id.add_data);
        update_data = (Button) findViewById(R.id.update_data);
        delete_data = (Button)findViewById(R.id.delete_data);
        query_data = (Button) findViewById(R.id.query_data);

        query_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                Cursor cursor = db.query("user", null, null, null, null, null, null);
                if (cursor.moveToNext()) {
                    do {
                        String username = cursor.getString(cursor.getColumnIndex("username"));
                        String email = cursor.getString(cursor.getColumnIndex("email"));
                        String tel = cursor.getString(cursor.getColumnIndex("tel"));
                        String password = cursor.getString(cursor.getColumnIndex("password"));
                        int age = cursor.getInt(cursor.getColumnIndex("age"));
                        String sex = cursor.getString(cursor.getColumnIndex("sex"));
                        int root_id = cursor.getInt(cursor.getColumnIndex("root_id"));

                        Log.d("MainActivity", "username is " + username);
                        Log.d("MainActivity", "email is " + email);
                        Log.d("MainActivity", "tel is " + tel);
                        Log.d("MainActivity", "password is " + password);
                        Log.d("MainActivity", "age is " + age);
                        Log.d("MainActivity", "sex is " + sex);
                        Log.d("MainActivity", "root_id is " + root_id);
                    } while (cursor.moveToNext());
                }
                cursor.close();
                Toast.makeText(MainActivity.this,"查询成功",Toast.LENGTH_SHORT).show();
            }


        });

        //删除数据
        delete_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                db.delete("user","username = ?",new String[]{"tom"});
            }
        });

        //更新数据
        update_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("username","黎黎");
                db.update("user",values,"username = ?",new String[]{"夏黎"});

            }
        });
        //添加数据
        add_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                //组装第一条数据
                values.put("username","tom");
                values.put("email","932250300@qq.com");
                values.put("tel","18875218975");
                values.put("password","123456");
                values.put("age","24");
                values.put("sex","女");
                db.insert("user",null,values); //插入第一条数据
                values.clear();
                //组装第二条数据
                values.put("username","angela");
                values.put("email","932250300@qq.com");
                values.put("tel","18984853307");
                values.put("password","123456");
                values.put("age","26");
                values.put("sex","男");
                db.insert("user",null,values); //插入第二条数据
                values.clear();
                //添加维修人员
                values.put("m_name","lili");
                values.put("m_email","932250300@qq.com");
                values.put("m_tel","13608544456");
                values.put("m_password","123456");
                values.put("m_age","26");
                values.put("m_sex","男");
                db.insert("maintainer",null,values); //插入第二条数据
                values.clear();
                //添加订单
                values.put("username","tom");
                values.put("linkman","zhangxuan");
                values.put("link_tel","18875218975");
                values.put("address","重庆师范大学雅风苑");
                values.put("q_detail","123456");
                values.put("m_name","lili");
                values.put("m_tel","13608544456");
                values.put("p_status","0");
                values.put("price","100");
                values.put("pay_method","支付宝");
                db.insert("ding",null,values); //插入第二条数据
                Toast.makeText(MainActivity.this,"添加成功",Toast.LENGTH_SHORT).show();
            }
        });
        //创建升级数据库
        cre_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.getWritableDatabase();
            }
        });

    }
}