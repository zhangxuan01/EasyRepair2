package com.example.easyrepair3;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;

public class IndexActivity extends TabActivity {
    private TabHost tabHost;
    private RadioButton main_tab_blogs;
    private RadioButton main_tab_shopping;
    private RadioButton main_tab_forum;
    private RadioButton main_tab_order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_index);
        main_tab_blogs = (RadioButton) findViewById(R.id.main_tab_blogs);


        tabHost = this.getTabHost();
        TabHost.TabSpec spec;
        Intent intent;

        intent = new Intent().setClass(this, BlogsActivity.class);
        spec = tabHost.newTabSpec("发现").setIndicator("发现").setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent().setClass(this,ShoppingActivity.class);
        spec = tabHost.newTabSpec("我的").setIndicator("我的").setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent().setClass(this,ForumActivity.class);
        spec = tabHost.newTabSpec("订单").setIndicator("订单").setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent().setClass(this,RepairActivity.class);
        spec = tabHost.newTabSpec("维修").setIndicator("维修").setContent(intent);
        tabHost.addTab(spec);

        RadioGroup radioGroup = (RadioGroup) this.findViewById(R.id.main_tab_group);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup,  int checkedId) {
                switch (checkedId)
                {
                    case R.id.main_tab_blogs:
                        tabHost.setCurrentTabByTag("发现");
                        break;
                    case R.id.main_tab_shopping:
                        tabHost.setCurrentTabByTag("我的");
                        break;
                    case R.id.main_tab_forum:
                        tabHost.setCurrentTabByTag("订单");
                        break;
                    case R.id.main_tab_order:
                        tabHost.setCurrentTabByTag("维修");
                        break;
                    default:
                        // tabHost.setCurrentTabByTag("�ҵĿ���");
                        break;
                }
            }
        });


    }
}
