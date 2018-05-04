package com.example.easyrepair3;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TabHost;

import java.util.ArrayList;
import java.util.List;

public class BlogsActivity extends TabActivity {
    private List<Blog01> blog01List = new ArrayList<>();
    private List<Blog01> blog02List = new ArrayList<>();
    private List<Blog01> blog03List = new ArrayList<>();
    private List<Blog01> blog04List = new ArrayList<>();
    private List<Blog01> blog05List = new ArrayList<>();
    private List<Blog01> blog06List = new ArrayList<>();
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

        initblog01();//初始化博客数据
        Blog01Adapter adapter1 = new Blog01Adapter(
                BlogsActivity.this,R.layout.blog01_item,blog01List);
        ListView listView1 = (ListView)findViewById(R.id.list_view1);
        listView1.setAdapter(adapter1);

        initblog02();
        Blog01Adapter adapter2 = new Blog01Adapter(
                BlogsActivity.this,R.layout.blog01_item,blog02List);
        ListView listView2 = (ListView)findViewById(R.id.list_view2);
        listView2.setAdapter(adapter2);

        initblog03();
        Blog01Adapter adapter3 = new Blog01Adapter(
                BlogsActivity.this,R.layout.blog01_item,blog03List);
        ListView listView3 = (ListView)findViewById(R.id.list_view3);
        listView3.setAdapter(adapter3);

        initblog04();
        Blog01Adapter adapter4 = new Blog01Adapter(
                BlogsActivity.this,R.layout.blog01_item,blog04List);
        ListView listView4 = (ListView)findViewById(R.id.list_view4);
        listView4.setAdapter(adapter4);

        initblog05();
        Blog01Adapter adapter5 = new Blog01Adapter(
                BlogsActivity.this,R.layout.blog01_item,blog05List);
        ListView listView5 = (ListView)findViewById(R.id.list_view5);
        listView5.setAdapter(adapter5);

        initblog06();
        Blog01Adapter adapter6 = new Blog01Adapter(
                BlogsActivity.this,R.layout.blog01_item,blog06List);
        ListView listView6 = (ListView)findViewById(R.id.list_view6);
        listView6.setAdapter(adapter6);
    }
    private void initblog01(){
        for (int i =0;i<2;i++){
            Blog01 list01 = new Blog01("AGP插槽的兼容性11111","AGP插槽的兼容性AGP插槽的兼容性");
            blog01List.add(list01);
            Blog01 list02 = new Blog01("IEXPLORE.EXE出错怎么办","IEXPLORE.EXE出错怎么办IEXPLORE.EXE出错怎么办");
            blog01List.add(list02);
            Blog01 list03 = new Blog01("系统每次启动都花屏","系统每次启动都花屏系统每次启动都花屏系统每次启动都花屏");
            blog01List.add(list03);
            Blog01 list04 = new Blog01("内存设置不当导致死机","内存设置不当导致死机内存设置不当导致死机内存设置不当导致死机");
            blog01List.add(list04);
            Blog01 list05 = new Blog01("硬盘自检后不直接进入系统， 提示按F1是什么含义","硬盘自检后不直接进入系统， 提示按F1是什么含义硬盘自检后不直接进入系统， 提示按F1是什么含义");
            blog01List.add(list05);
            Blog01 list06 = new Blog01("开机时硬盘发财吱吱声，重装系统也没用","开机时硬盘发财吱吱声，重装系统也没用开机时硬盘发财吱吱声，重装系统也没用开机时硬盘发财吱吱声，重装系统也没用开机时硬盘发财吱吱声，重装系统也没用");
            blog01List.add(list06);
        }
    }
    private void initblog02(){
        for (int i =0;i<2;i++){
            Blog01 list01 = new Blog01("AGP插槽的兼容性2222","AGP插槽的兼容性AGP插槽的兼容性");
            blog02List.add(list01);
            Blog01 list02 = new Blog01("IEXPLORE.EXE出错怎么办","IEXPLORE.EXE出错怎么办IEXPLORE.EXE出错怎么办");
            blog02List.add(list02);
            Blog01 list03 = new Blog01("系统每次启动都花屏","系统每次启动都花屏系统每次启动都花屏系统每次启动都花屏");
            blog02List.add(list03);
            Blog01 list04 = new Blog01("内存设置不当导致死机","内存设置不当导致死机内存设置不当导致死机内存设置不当导致死机");
            blog02List.add(list04);
            Blog01 list05 = new Blog01("硬盘自检后不直接进入系统， 提示按F1是什么含义","硬盘自检后不直接进入系统， 提示按F1是什么含义硬盘自检后不直接进入系统， 提示按F1是什么含义");
            blog02List.add(list05);
            Blog01 list06 = new Blog01("开机时硬盘发财吱吱声，重装系统也没用","开机时硬盘发财吱吱声，重装系统也没用开机时硬盘发财吱吱声，重装系统也没用开机时硬盘发财吱吱声，重装系统也没用开机时硬盘发财吱吱声，重装系统也没用");
            blog02List.add(list06);
        }
    }
    private void initblog03(){
        for (int i =0;i<2;i++){
            Blog01 list01 = new Blog01("AGP插槽的兼容性33333","AGP插槽的兼容性AGP插槽的兼容性");
            blog03List.add(list01);
            Blog01 list02 = new Blog01("IEXPLORE.EXE出错怎么办","IEXPLORE.EXE出错怎么办IEXPLORE.EXE出错怎么办");
            blog03List.add(list02);
            Blog01 list03 = new Blog01("系统每次启动都花屏","系统每次启动都花屏系统每次启动都花屏系统每次启动都花屏");
            blog03List.add(list03);
            Blog01 list04 = new Blog01("内存设置不当导致死机","内存设置不当导致死机内存设置不当导致死机内存设置不当导致死机");
            blog03List.add(list04);
            Blog01 list05 = new Blog01("硬盘自检后不直接进入系统， 提示按F1是什么含义","硬盘自检后不直接进入系统， 提示按F1是什么含义硬盘自检后不直接进入系统， 提示按F1是什么含义");
            blog03List.add(list05);
            Blog01 list06 = new Blog01("开机时硬盘发财吱吱声，重装系统也没用","开机时硬盘发财吱吱声，重装系统也没用开机时硬盘发财吱吱声，重装系统也没用开机时硬盘发财吱吱声，重装系统也没用开机时硬盘发财吱吱声，重装系统也没用");
            blog03List.add(list06);
        }
    }
    private void initblog04(){
        for (int i =0;i<2;i++){
            Blog01 list01 = new Blog01("AGP插槽的兼容性444444","AGP插槽的兼容性AGP插槽的兼容性");
            blog04List.add(list01);
            Blog01 list02 = new Blog01("IEXPLORE.EXE出错怎么办","IEXPLORE.EXE出错怎么办IEXPLORE.EXE出错怎么办");
            blog04List.add(list02);
            Blog01 list03 = new Blog01("系统每次启动都花屏","系统每次启动都花屏系统每次启动都花屏系统每次启动都花屏");
            blog04List.add(list03);
            Blog01 list04 = new Blog01("内存设置不当导致死机","内存设置不当导致死机内存设置不当导致死机内存设置不当导致死机");
            blog04List.add(list04);
            Blog01 list05 = new Blog01("硬盘自检后不直接进入系统， 提示按F1是什么含义","硬盘自检后不直接进入系统， 提示按F1是什么含义硬盘自检后不直接进入系统， 提示按F1是什么含义");
            blog04List.add(list05);
            Blog01 list06 = new Blog01("开机时硬盘发财吱吱声，重装系统也没用","开机时硬盘发财吱吱声，重装系统也没用开机时硬盘发财吱吱声，重装系统也没用开机时硬盘发财吱吱声，重装系统也没用开机时硬盘发财吱吱声，重装系统也没用");
            blog04List.add(list06);
        }
    }
    private void initblog05(){
        for (int i =0;i<2;i++){
            Blog01 list01 = new Blog01("AGP插槽的兼容性55555","AGP插槽的兼容性AGP插槽的兼容性");
            blog05List.add(list01);
            Blog01 list02 = new Blog01("IEXPLORE.EXE出错怎么办","IEXPLORE.EXE出错怎么办IEXPLORE.EXE出错怎么办");
            blog05List.add(list02);
            Blog01 list03 = new Blog01("系统每次启动都花屏","系统每次启动都花屏系统每次启动都花屏系统每次启动都花屏");
            blog05List.add(list03);
            Blog01 list04 = new Blog01("内存设置不当导致死机","内存设置不当导致死机内存设置不当导致死机内存设置不当导致死机");
            blog05List.add(list04);
            Blog01 list05 = new Blog01("硬盘自检后不直接进入系统， 提示按F1是什么含义","硬盘自检后不直接进入系统， 提示按F1是什么含义硬盘自检后不直接进入系统， 提示按F1是什么含义");
            blog05List.add(list05);
            Blog01 list06 = new Blog01("开机时硬盘发财吱吱声，重装系统也没用","开机时硬盘发财吱吱声，重装系统也没用开机时硬盘发财吱吱声，重装系统也没用开机时硬盘发财吱吱声，重装系统也没用开机时硬盘发财吱吱声，重装系统也没用");
            blog05List.add(list06);
        }
    }
    private void initblog06(){
        for (int i =0;i<2;i++){
            Blog01 list01 = new Blog01("AGP插槽的兼容性6666","AGP插槽的兼容性AGP插槽的兼容性");
            blog06List.add(list01);
            Blog01 list02 = new Blog01("IEXPLORE.EXE出错怎么办","IEXPLORE.EXE出错怎么办IEXPLORE.EXE出错怎么办");
            blog06List.add(list02);
            Blog01 list03 = new Blog01("系统每次启动都花屏","系统每次启动都花屏系统每次启动都花屏系统每次启动都花屏");
            blog06List.add(list03);
            Blog01 list04 = new Blog01("内存设置不当导致死机","内存设置不当导致死机内存设置不当导致死机内存设置不当导致死机");
            blog06List.add(list04);
            Blog01 list05 = new Blog01("硬盘自检后不直接进入系统， 提示按F1是什么含义","硬盘自检后不直接进入系统， 提示按F1是什么含义硬盘自检后不直接进入系统， 提示按F1是什么含义");
            blog06List.add(list05);
            Blog01 list06 = new Blog01("开机时硬盘发财吱吱声，重装系统也没用","开机时硬盘发财吱吱声，重装系统也没用开机时硬盘发财吱吱声，重装系统也没用开机时硬盘发财吱吱声，重装系统也没用开机时硬盘发财吱吱声，重装系统也没用");
            blog06List.add(list06);
        }
    }
}
