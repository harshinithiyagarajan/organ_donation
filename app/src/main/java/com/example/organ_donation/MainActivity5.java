package com.example.organ_donation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity5 extends AppCompatActivity {
    public String fname="",lname="",phone="",blood="",result="";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        Bundle b=getIntent().getExtras();
        if(b!=null){
            fname=b.getString("fname");
            lname=b.getString("lname");
            phone=b.getString("phone");
            blood=b.getString("blood");
            result=b.getString("organ");
            TextView t1=findViewById(R.id.fname);
            t1.setText(fname);
            TextView t2=findViewById(R.id.lname);
            t2.setText(lname);
            TextView t3=findViewById(R.id.phone);
            t3.setText(phone);
            TextView t4=findViewById(R.id.bgroup);
            t4.setText(blood);
            TextView t5=findViewById(R.id.organ);
            t5.setText(result);
        }

    }
}
