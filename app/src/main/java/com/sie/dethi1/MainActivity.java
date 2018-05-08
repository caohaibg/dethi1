package com.sie.dethi1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editten, editNS,  editDC;
    private RadioGroup radioGroup1;
    private RadioButton radNu, radNam;
    private CheckBox chkitem1, chkitem2, chkitem3;
    private Button btnAdd, btnhienthi;
    private ListView list;
    private ArrayList<thisinhmodel> thisinh = new ArrayList<>();
    int gt= 1, enjoy=1;
    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database=new Database(this);

        editten = (EditText)findViewById(R.id.editten);
        editNS = (EditText)findViewById(R.id.editNS);
        editDC = (EditText) findViewById(R.id.editDC);

        radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup1);
        radNu = (RadioButton) findViewById(R.id.radNu);
        radNam = (RadioButton) findViewById(R.id.radNam);
        chkitem1=(CheckBox)findViewById(R.id.chkitem1);
        chkitem2=(CheckBox) findViewById(R.id.chkitem2);
        chkitem3=(CheckBox) findViewById(R.id.chkitem3);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnhienthi = (Button) findViewById(R.id.btnhienthi);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sulynhap();
            }
        });
        btnhienthi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sulyhienthi();
            }
        });

    }

    private void sulyhienthi() {
        kq();
        Intent intent = new Intent(MainActivity.this, man2.class);
        intent.putExtra("TEN", editten.getText().toString());
        intent.putExtra("DIACHI", editDC.getText().toString());
        intent.putExtra("NAMSINH", editNS.getText().toString());
        intent.putExtra("GENDER", gt);
        intent.putExtra("TRUONGYT", enjoy);
        startActivity(intent);
    }

    public void sulynhap(){
        kq();
        thisinhmodel ts=new thisinhmodel();
        ts.setTen(editten.getText().toString());
        ts.setDiachi(editDC.getText().toString());
        ts.setGender(gt);
        ts.setTruongyt(enjoy);

        database.add(ts);
        Toast.makeText(this, "them thanh cong", Toast.LENGTH_SHORT).show();

    }
    public void kq(){

        if (radNam.isChecked()){
            gt=1;
        }else {
            gt=2;
        }

        if (chkitem1.isChecked()){
            enjoy=1;
        }else if (chkitem2.isChecked()){
            enjoy=2;
        }else {
            enjoy=3;
        }
    }

}
