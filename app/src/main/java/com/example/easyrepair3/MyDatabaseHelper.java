package com.example.easyrepair3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Administrator on 2018/4/17.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {
    public static final String CREATE_USER = "create table user("
            + "id integer primary key autoincrement,"
            + "username text,"      //用户名
            + "email text,"          //邮箱
            + "tel text,"           //手机号
            + "password text,"     //密码
            + "age integer,"      //年龄
            + "sex text,"          //性别
           + "root_id integer)";     //权限

    public static final String CREATE_ROOT = "create table root("
            +"id integer primary key autoincrement," //权限id
            +"role_name text)";                          //权限名称

    private Context mContext;

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER);
        db.execSQL(CREATE_ROOT);
        Toast.makeText(mContext, "数据创建或打开成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists user");
        db.execSQL("drop table if exists root");
        onCreate(db);
    }
}
