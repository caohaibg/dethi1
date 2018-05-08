package com.sie.dethi1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class man2 extends AppCompatActivity {

    TextView ten, diachi, namsinh, gender, truongyt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man2);

        ten = (TextView) findViewById(R.id.textView1);
        diachi = (TextView) findViewById(R.id.textView2);
        namsinh = (TextView) findViewById(R.id.textView3);
        gender = (TextView) findViewById(R.id.textView4);
        truongyt = (TextView) findViewById(R.id.textView5);

        Intent intent= getIntent();
        if (intent!=null){
            ten.setText(intent.getStringExtra("TEN"));
            diachi.setText(intent.getStringExtra("DIACHI"));
            namsinh.setText(intent.getStringExtra("NAMSINH"));
            gender.setText(intent.getStringExtra("GENDER"));
            truongyt.setText(intent.getStringExtra("TRUONGYT"));
        }
    }
}
