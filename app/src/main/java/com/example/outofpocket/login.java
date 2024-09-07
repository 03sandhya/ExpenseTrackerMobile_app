package com.example.outofpocket;

import androidx.appcompat.app.AppCompatActivity;
import android.util.Patterns;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText ee1, ee2;
    TextView tv;
    Button lb,reg;
    ImageView iv1, iv2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        iv1 = (ImageView) findViewById(R.id.icon1);
        iv2 = (ImageView) findViewById(R.id.icon2);
        tv = (TextView) findViewById(R.id.t1);
        ee1 = (EditText) findViewById(R.id.e1);
        ee2 = (EditText) findViewById(R.id.e2);
        lb = (Button) findViewById(R.id.login);
        reg=(Button)findViewById(R.id.register);
        lb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = ee1.getText().toString();
                String pass = ee2.getText().toString();
                if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches() && !pass.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Login Successfull ", Toast.LENGTH_SHORT).show();
                    Intent i1 = new Intent(getApplicationContext(), Dashboard.class);
                    startActivity(i1);
                } else if (pass.isEmpty() && email.isEmpty()) {
                    ee1.setError("Please Enter mail ");
                    ee2.setError("Please enter password");
                }
                else if (pass.isEmpty()) {
                    ee2.setError("Enter Valid password ");
                }
                else {
                    ee1.setError("Enter valid mail");
                }

            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Signup.class);
                startActivity(intent);
            }
        });

    }
}

