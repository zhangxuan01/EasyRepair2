package com.example.easyrepair3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private MyDatabaseHelper dbHelper;
    private TextView register;
    private EditText usernameEdit;
    private EditText passwordEdit;
    private Button login;
    private TextView tel_login;
    private CheckBox rememberPass;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private TextView find_pass;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dbHelper = new MyDatabaseHelper(this,"Easy.db",null,10);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        register = (TextView) findViewById(R.id.register);
        usernameEdit = (EditText)findViewById(R.id.username);
        passwordEdit = (EditText) findViewById(R.id.password);
        rememberPass =(CheckBox)findViewById(R.id.remember_pass);
        login = (Button) findViewById(R.id.login);
        tel_login = (TextView) findViewById(R.id.tel_login);
        boolean isRemember = pref.getBoolean("remember_password",false);
        tel_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this,TelActivity.class);
                startActivity(intent);
            }
        });
        //数据库
        find_pass = (TextView)findViewById(R.id.find_pass);
        find_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        //用户登录
        if (isRemember){
            String username = pref.getString("username","");
            String password = pref.getString("password","");

            usernameEdit.setText(username);
            passwordEdit.setText(password);
            rememberPass.setChecked(true);

        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                Cursor cursor = db.rawQuery("select * from user where username=? and password=?", new String[]{username,password});
                if(cursor.moveToNext()){
                    editor = pref.edit();
                    if(rememberPass.isChecked()){
                       editor.putBoolean("remember_password",true);
                       editor.putString("username",username);
                       editor.putString("password",password);
                   }else {
                       editor.clear();
                   }
                  editor.apply();

                    Intent intent = new Intent();
                    intent=new Intent(LoginActivity.this ,IndexActivity.class);
                    startActivity( intent);
                } else{
                    Toast. makeText(getApplicationContext(), "用户名或密码错误", Toast.LENGTH_LONG ).show();
                }
                db.close();

            }
        });



        //用户注册
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
    });
    }
}

