package com.example.easyrepair3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class DingdanActivity extends AppCompatActivity {

    private EditText e_ren,e_dianhua,e_address,e_describe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dingdan);

        ImageView iv_back = (ImageView) findViewById(R.id.iv_back);

        e_ren = (EditText) findViewById(R.id.e_ren);

        iv_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               finish();
            }

        });
    }
}

