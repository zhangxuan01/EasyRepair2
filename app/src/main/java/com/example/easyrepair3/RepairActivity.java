package com.example.easyrepair3;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RepairActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repair);
        Button b_order = (Button) findViewById(R.id.b_order);
        Button b_phone = (Button) findViewById(R.id.b_phone);
        b_order.setOnClickListener(this);
        b_phone.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b_order:
                Intent intent = new Intent(RepairActivity.this, DingdanActivity.class);
                startActivity(intent);
                break;
            case R.id.b_phone:
                if(ContextCompat.checkSelfPermission(RepairActivity.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(RepairActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 2);
                }else {
                    call();
                }
                break;
        }
    }

    private void call(){
        try{
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:13372629148"));
            startActivity(intent);
        }catch(SecurityException e){
            e.printStackTrace();
        }
    }

    public void onRequestPermissionsResult(int requestCode,String[] permissions,int[] grantResults){
        switch(requestCode){
            case 2:
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    call();
                }else{
                    Toast.makeText(this,"You denied the permission",Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }
}



