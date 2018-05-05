package com.example.easyrepair3;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ChangeProfileActivity extends AppCompatActivity implements View.OnClickListener {
    private MyDatabaseHelper dbHelper;
    private Toolbar toolbar;
    private ImageView iv_back;
    private TextView tv_change_name;
    private TextView tv_change_tel;
    private TextView tv_change_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_profile);
        dbHelper = new MyDatabaseHelper(this,"Easy.db",null,10);


        initViews();

        setToolbar();
        setListeners();
        SharedPreferences pref= PreferenceManager.getDefaultSharedPreferences(this);
        String username = pref.getString("username","");
        tv_change_name.setText(username);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user where username=?", new String[]{username});
        if (cursor.moveToNext()) {
            do {

                String email = cursor.getString(cursor.getColumnIndex("email"));
                String tel = cursor.getString(cursor.getColumnIndex("tel"));

                tv_change_tel.setText(tel);
                tv_change_email.setText(email);

            } while (cursor.moveToNext());
        }
        cursor.close();
    }

    private void initViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        iv_back = (ImageView) findViewById(R.id.iv_back);
        tv_change_name = (TextView) findViewById(R.id.tv_change_name);
        tv_change_tel = (TextView) findViewById(R.id.tv_change_tel);
        tv_change_email = (TextView)findViewById(R.id.tv_change_email);

    }
    private void setListeners() {
        iv_back.setOnClickListener(this);
    }
    private void setToolbar() {
        //设置导航图标要在setSupportActionBar方法之后
        Utils.initToolbar(this, toolbar, "", "", 0, null);

        toolbar.setAlpha(0);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
               finish();
        }

    }

}


