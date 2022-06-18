package com.example.organ_donation;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        EditText ln=findViewById(R.id.lname);
        EditText fn=findViewById(R.id.fname);
        EditText pn=findViewById(R.id.phone);
        EditText add=findViewById(R.id.paddress);
        EditText a=findViewById(R.id.age);
        Button b1=findViewById(R.id.firstNext);
        RadioButton r1=findViewById(R.id.radioFemale);
        RadioButton r2=findViewById(R.id.radioMale);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int dob=Integer.parseInt(a.getText().toString());
                if(TextUtils.isEmpty(ln.getText()) && TextUtils.isEmpty(fn.getText()) &&  TextUtils.isEmpty(add.getText()) && TextUtils.isEmpty(pn.getText()) && (!r1.isChecked() || !r2.isChecked())) {
                    Toast.makeText(MainActivity3.this, "Enter all credentials", Toast.LENGTH_SHORT).show();
                }
                else {
                    if ( !TextUtils.isEmpty(a.getText()) && dob >= 18) {
                        Toast.makeText(MainActivity3.this, "You are eligible to donate", Toast.LENGTH_SHORT).show();

                        String m = fn.getText().toString();
                        String m2=ln.getText().toString();
                        String m3=pn.getText().toString();
                        Bundle b=new Bundle();
                        b.putString("fname",m);
                        b.putString("lname",m2);
                        b.putString("phone",m3);
                        Intent i = new Intent(MainActivity3.this, MainActivity4.class);
                        i.putExtras(b);
                        startActivityForResult(i, 0);
                    }
                    else {
                        Toast.makeText(MainActivity3.this, "You are not eligible to donate because you haven't reached 18 years!!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
