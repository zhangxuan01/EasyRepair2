package com.example.easyrepair3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AnquanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anquan);
        ImageView iv_back = (ImageView) findViewById(R.id.iv_back);
        TextView telephone = (TextView) findViewById(R.id.telephone);
        TextView password = (TextView)findViewById(R.id.password);

        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(AnquanActivity.this,ModifierPassActivity.class);
                startActivity(intent);
            }
        });

        telephone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(AnquanActivity.this,BindActivity.class);
                startActivity(intent);
            }
        });

        iv_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }

        });
    }
}