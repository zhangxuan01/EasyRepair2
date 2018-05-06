package com.example.easyrepair3;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BindActivity extends AppCompatActivity {
    private MyDatabaseHelper dbHelper;
    private  String bind_tel1;
    private  String username;
    private EditText bind_tel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind);
        dbHelper = new MyDatabaseHelper(this,"Easy.db",null,10);
        TextView tv_change_tel = (TextView) findViewById(R.id.tv_change_tel);
        bind_tel = (EditText)findViewById(R.id.bind_tel);
        Button bind =(Button)findViewById(R.id.bind);
        ImageView iv_back = (ImageView) findViewById(R.id.iv_back);




        SharedPreferences pref= PreferenceManager.getDefaultSharedPreferences(this);
         username = pref.getString("username","");

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user where username=?", new String[]{username});
        if (cursor.moveToNext()) {
            do {


                String tel = cursor.getString(cursor.getColumnIndex("tel"));

                tv_change_tel.setText(tel);

            } while (cursor.moveToNext());
        }
        cursor.close();

        bind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bind_tel1 = bind_tel.getText().toString();
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("tel",bind_tel1);
                db.update("user",values,"username = ?",new String[]{username});
                Toast.makeText(BindActivity.this,"修改成功",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent=new Intent(BindActivity.this ,AnquanActivity.class);
                startActivity(intent);

            }
        });
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
