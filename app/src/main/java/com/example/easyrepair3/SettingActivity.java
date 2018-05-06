package com.example.easyrepair3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SettingActivity extends AppCompatActivity {
        private TextView out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ImageView iv_back = (ImageView) findViewById(R.id.iv_back);
        out = (TextView)findViewById(R.id.out);

        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        iv_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }

        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}