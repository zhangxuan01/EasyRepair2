package com.example.easyrepair3;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class ForumActivity extends TabActivity {
//    private List<order> order01List = new ArrayList<>();
//    private List<order> order02List = new ArrayList<>();
//    private List<order> order03List = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);
        TabHost tabHost = getTabHost();

        TabHost.TabSpec tab01,tab02;


        tab01 = tabHost.newTabSpec("tab1").setIndicator("待评价").setContent(R.id.tab01);
        tabHost.addTab(tab01);

        tab02 = tabHost.newTabSpec("tab2").setIndicator("全部订单").setContent(R.id.tab02);
        tabHost.addTab(tab02);
    }
}
