package com.example.easyrepair3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ShoppingActivity extends AppCompatActivity implements View.OnClickListener, MyScrollView.ScrollingListener {
    private Toolbar toolbar;
    private MyScrollView my_scroll_view;
    private View divider0;
    private ImageView iv_header;//头像
    private TextView tv_title,tv_nickname,wallet,collection,jifen,anquan,guanyu,setting;//"个人中心"，昵称，钱包，收藏，积分，安全，关于，设置

    private float alphaHeight = 0;//透明度渐变的高度
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);
        initViews();
        initData();
        setToolbar();
        setListeners();
    }
    private void initData() {
        alphaHeight = Utils.dip2px(this, 160);
        tv_title.setVisibility(View.INVISIBLE);//"个人中心"暂时不可见
    }

    private void initViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        my_scroll_view = (MyScrollView) findViewById(R.id.my_scroll_view);
        divider0 = findViewById(R.id.divider0);

        tv_title = (TextView) findViewById(R.id.tv_title);

        iv_header = (ImageView) findViewById(R.id.iv_header);//头像
        tv_nickname = (TextView) findViewById(R.id.tv_nickname);//昵称
        wallet = (TextView) findViewById(R.id.wallet);//钱包
        collection = (TextView) findViewById(R.id.collection);//收藏
        jifen= (TextView) findViewById(R.id.jifen);//积分
        anquan = (TextView) findViewById(R.id.anquan );//账户与安全
        guanyu = (TextView) findViewById(R.id.guanyu);//关于
        setting = (TextView) findViewById(R.id.setting);//设置
    }
    private void setListeners() {

        my_scroll_view.setScrollingListener(this);

        iv_header.setOnClickListener(this);//头像
        tv_nickname.setOnClickListener(this);//昵称
        wallet.setOnClickListener(this);//钱包
        collection.setOnClickListener(this);//收藏
        jifen.setOnClickListener(this);//积分
        anquan.setOnClickListener(this);//账户与安全
        guanyu.setOnClickListener(this);//关于
        setting.setOnClickListener(this);//设置
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_header:
                startProfileActivity();
                break;
            case  R.id.tv_nickname:
                startProfileActivity();
                break;
            case R.id.wallet://钱包
                Intent intent = new Intent(ShoppingActivity.this, WalletActivity.class);
                startActivity(intent);
                break;
            case R.id.collection://收藏
                Intent intent1 = new Intent(ShoppingActivity.this, CollectionActivity.class);
                startActivity(intent1);
                break;
            case R.id.jifen://积分
                Intent intent2 = new Intent(ShoppingActivity.this, JifenActivity.class);
                startActivity(intent2);
                break;
            case R.id.anquan://账户与安全
                Intent intent3 = new Intent(ShoppingActivity.this, AnquanActivity.class);
                startActivity(intent3);
                break;
            case R.id.guanyu://账户与安全
                Intent intent4 = new Intent(ShoppingActivity.this, GuanyuActivity.class);
                startActivity(intent4);
                break;
            case R.id.setting://设置
                Intent intent5 = new Intent(ShoppingActivity.this, SettingActivity.class);
                startActivity(intent5);
                break;
        }
    }

    private void startProfileActivity() {
        Intent intent = new Intent(ShoppingActivity.this, ChangeProfileActivity.class);
        startActivity(intent);
    }

    @Override
    public void onScrolling(int l, int t, int oldl, int oldt) {
        float alpha = t * 1.0f / alphaHeight;
        if (alpha < 0.4f) {
            alpha = 0;
            if (divider0.getVisibility() == View.VISIBLE) {
                divider0.setVisibility(View.INVISIBLE);
                tv_title.setVisibility(View.INVISIBLE);
            }
        } else {
            if (divider0.getVisibility() == View.INVISIBLE) {
                divider0.setVisibility(View.VISIBLE);
                tv_title.setVisibility(View.VISIBLE);
            }
        }
        toolbar.setAlpha(alpha);
    }

}
