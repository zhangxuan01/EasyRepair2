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
            + "username text unique,"      //用户名
            + "email text,"          //邮箱
            + "tel text,"           //手机号
            + "password text,"     //密码
            + "age integer,"      //年龄
            + "sex text)";          //性别

    public static final String CREATE_MATATAINER = "create table maintainer("
            + "id integer primary key autoincrement,"
            + "m_name text unique,"      //用户名
            + "m_email text,"          //邮箱
            + "m_tel text,"           //手机号
            + "m_password text,"     //密码
            + "m_age integer,"      //年龄
            + "m_sex text)";          //性别


    public  static final String CREATE_DING = "create table ding("
            + "id integer primary key autoincrement,"
            + "username text,"      //用户名
            + "linkman text,"          //联系人
            + "link_tel text,"           //联系人手机号
            + "address text,"           //地址
            + "q_detail text,"     //问题描述
            + "m_name text,"      //维修人员姓名
            + "m_tel text,"       //维修人员电话
            + "price integer,"       //价格
            + "p_status integer," //付款状态
            + "pay_method text)";     //付款方式

    private Context mContext;

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER);
        db.execSQL(CREATE_MATATAINER);
        db.execSQL(CREATE_DING);
        Toast.makeText(mContext, "数据创建或打开成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists user");
        db.execSQL("drop table if exists maintainer");
        db.execSQL("drop table if exists ding");
        onCreate(db);
    }
}
