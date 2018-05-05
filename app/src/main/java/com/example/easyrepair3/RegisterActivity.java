package com.example.easyrepair3;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private EditText telEdit;
    private EditText usernameEdit;
    private EditText passwordEdit;
    private EditText emailEdit;
    private Button register;
    private MyDatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        telEdit = (EditText)findViewById(R.id.telEdit);
        usernameEdit = (EditText)findViewById(R.id.usernameEdit);
        passwordEdit = (EditText)findViewById(R.id.passwordEdit);
        emailEdit = (EditText)findViewById(R.id.emailEdit);
        register = (Button) findViewById(R.id.register);
        dbHelper = new MyDatabaseHelper(this,"Easy.db",null,10);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tel = telEdit.getText().toString();
                String username = usernameEdit.getText().toString();
                String email = emailEdit.getText().toString();
                String password = passwordEdit.getText().toString();

                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                //组装第一条数据
                values.put("username",username);
                values.put("email",email);
                values.put("tel",tel);
                values.put("password",password);
                values.put("root_id","4");
                db.insert("user",null,values); //插入第一条数据
                values.clear();
                Intent intent = new Intent();
                intent.setClass(RegisterActivity.this,MainActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"注册成功",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
