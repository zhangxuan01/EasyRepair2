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
import android.widget.Toast;

public class ModifierPassActivity extends AppCompatActivity {
    private MyDatabaseHelper dbHelper;
    private EditText cur_pass;
    private EditText cur_pass_new;
    private EditText cur_pass_new1;
    private Button modify;
    private String username;
    private String Cur_pass ;
    private String Cur_pass_new;
    private String Cur_pass_new1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier_pass);

        dbHelper = new MyDatabaseHelper(this,"Easy.db",null,10);
        cur_pass =(EditText)findViewById(R.id.cur_pass);
        cur_pass_new =(EditText)findViewById(R.id.cur_pass_new);
        cur_pass_new1 =(EditText)findViewById(R.id.cur_pass_new1);
        modify = (Button)findViewById(R.id.modify);

        SharedPreferences pref= PreferenceManager.getDefaultSharedPreferences(this);
        username = pref.getString("username","");
        modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Cur_pass = cur_pass.getText().toString();

                SQLiteDatabase db = dbHelper.getWritableDatabase();
                Cursor cursor = db.rawQuery("select * from user where username=? and password=?", new String[]{username,Cur_pass});
                if(cursor.moveToNext()){
                    Cur_pass_new = cur_pass_new.getText().toString();
                    Cur_pass_new1 = cur_pass_new1.getText().toString();

                    ContentValues values = new ContentValues();
                    values.put("password", Cur_pass_new);
                    db.update("user", values, "username = ?", new String[]{username});
                    Toast.makeText(ModifierPassActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    intent = new Intent(ModifierPassActivity.this, AnquanActivity.class);
                    startActivity(intent);

            }else{
                    Toast. makeText(getApplicationContext(), "用户名或密码错误", Toast.LENGTH_LONG ).show();
                }
                db.close();

            }
        });
    }
}
