package com.example.organ_donation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String uname="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1=findViewById(R.id.login);
        EditText name=findViewById(R.id.uname);
        EditText mail=findViewById(R.id.email);
        EditText pass=findViewById(R.id.pword);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(name.getText()) && TextUtils.isEmpty(mail.getText()) && TextUtils.isEmpty(pass.getText())){
                    Toast.makeText(MainActivity.this, "Credentials should not be empty", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent i = new Intent(MainActivity.this, MainActivity2.class);
                    EditText editText = findViewById(R.id.uname);
                    String message = editText.getText().toString();
                    i.putExtra(uname, message);
                    startActivityForResult(i, 0);

                }
            }
        });
    }
}