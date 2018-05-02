package com.example.easyrepair3;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TelActivity extends AppCompatActivity {
    private EditText telEdit;
    private EditText passwordEdit;
    private Button tel_login;
    private MyDatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tel);
        telEdit = (EditText) findViewById(R.id.tel);
        passwordEdit = (EditText)findViewById(R.id.password);
        dbHelper = new MyDatabaseHelper(this,"Easy.db",null,4);
        tel_login = (Button)findViewById(R.id.tel_login);
        tel_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tel = telEdit.getText().toString();
                String password = passwordEdit.getText().toString();

                SQLiteDatabase db = dbHelper.getWritableDatabase();
                Cursor cursor = db.rawQuery("select * from user where tel = ? and password = ?",new String[]{tel,password});
                if (cursor.moveToNext()){
                    Intent intent = new Intent();
                    intent.setClass(TelActivity.this,IndexActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(),"手机号或密码错误",Toast.LENGTH_SHORT);
                }
                db.close();

            }
        });
    }
}
