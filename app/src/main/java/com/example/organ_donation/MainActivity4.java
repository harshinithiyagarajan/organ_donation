package com.example.organ_donation;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4 extends AppCompatActivity {
    //public static final String uname="",uname2="";
    public String fname="",lname="",phone="",blood="";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        CheckBox c=findViewById(R.id.check);
        Button b1=findViewById(R.id.dnext);
        EditText bg=findViewById(R.id.bgroup);
        RadioButton r1=findViewById(R.id.radioCornea);
        RadioButton r2=findViewById(R.id.radioLiver);
        RadioButton r3=findViewById(R.id.radioLungs);
        RadioButton r4=findViewById(R.id.radioHeart);
        RadioButton r5=findViewById(R.id.radioKidneys);
        RadioButton r6=findViewById(R.id.radioPancreas);
        Bundle b=getIntent().getExtras();
        if(b!=null){
             fname=b.getString("fname");
             lname=b.getString("lname");
             phone=b.getString("phone");
        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(c.isChecked() && !TextUtils.isEmpty(bg.getText()) && (r1.isChecked() || r2.isChecked() || r3.isChecked() || r4.isChecked() || r5.isChecked() || r6.isChecked())){
                    String result="";
                    result+=(r1.isChecked())?"Cornea":(r2.isChecked())?"Liver":(r3.isChecked())?"Lungs":(r4.isChecked())?"Heart":(r5.isChecked())?"Kidney":(r6.isChecked())?"Pancreas":" ";
                    blood=bg.getText().toString();
                    Bundle b=new Bundle();
                    b.putString("fname",fname);
                    b.putString("lname",lname);
                    b.putString("phone",phone);
                    b.putString("blood",blood);
                    b.putString("organ",result);
                    Intent i = new Intent(MainActivity4.this, MainActivity5.class);
                    i.putExtras(b);
                    startActivityForResult(i, 0);

                    Toast.makeText(MainActivity4.this, result, Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity4.this, "Enter all credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
