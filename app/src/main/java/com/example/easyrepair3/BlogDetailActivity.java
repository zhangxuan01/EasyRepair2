package com.example.easyrepair3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class BlogDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_detail);
        ImageView iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }

        });

        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        String content = bundle.getString("content");
        TextView blogname = (TextView) findViewById(R.id.blog01_name1);
        blogname.setText(name);
        TextView blogcontent = (TextView) findViewById(R.id.blog01_content1);
        blogcontent.setText(content);
    }
}
