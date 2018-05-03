package com.example.easyrepair3;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class BlogsActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blogs);
        TabHost tabHost = getTabHost();

        TabHost.TabSpec tab01,tab02,tab03,tab04,tab05,tab06;


        tab01 = tabHost.newTabSpec("tab1").setIndicator("常见故障").setContent(R.id.tab01);
        tabHost.addTab(tab01);

        tab02 = tabHost.newTabSpec("tab2").setIndicator("主板").setContent(R.id.tab02);
        tabHost.addTab(tab02);

        tab03 = tabHost.newTabSpec("tab3").setIndicator("硬盘").setContent(R.id.tab03);
        tabHost.addTab(tab03);

        tab04 = tabHost.newTabSpec("tab4").setIndicator("CPU").setContent(R.id.tab04);
        tabHost.addTab(tab04);

        tab05 = tabHost.newTabSpec("tab5").setIndicator("内存").setContent(R.id.tab05);
        tabHost.addTab(tab05);

        tab06 = tabHost.newTabSpec("tab6").setIndicator("其他").setContent(R.id.tab06);
        tabHost.addTab(tab06);
    }
}
