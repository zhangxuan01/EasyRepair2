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
        spec = tabHost.newTabSpec("博客").setIndicator("博客").setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent().setClass(this,ShoppingActivity.class);
        spec = tabHost.newTabSpec("我的").setIndicator("我的").setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent().setClass(this,ForumActivity.class);
        spec = tabHost.newTabSpec("论坛").setIndicator("论坛").setContent(intent);
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
                        tabHost.setCurrentTabByTag("博客");
                        break;
                    case R.id.main_tab_shopping:
                        tabHost.setCurrentTabByTag("我的");
                        break;
                    case R.id.main_tab_forum:
                        tabHost.setCurrentTabByTag("论坛");
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
