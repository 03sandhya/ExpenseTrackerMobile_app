package com.example.outofpocket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Patterns;
import android.content.Intent;

public class Signup extends AppCompatActivity {
    EditText editTextusername1, editTextemail2, editTextPassword;
    Button buttonSignup;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        buttonSignup=(Button)findViewById(R.id.bbSignup);
        editTextusername1=(EditText)findViewById(R.id.et1);
        editTextemail2=(EditText)findViewById(R.id.et2);
        editTextPassword=(EditText)findViewById(R.id.etPassword);
        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();

            }
        });
    }


    public void signUp() {
        String name = editTextusername1.getText().toString().trim();
        String email = editTextemail2.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();


        if (!name.isEmpty() && !email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches() && !password.isEmpty()) {
            Toast.makeText(this, " Registered Successfully", Toast.LENGTH_SHORT).show();
            Intent i1 = new Intent(getApplicationContext(), Dashboard.class);
            i1.putExtra("name",name);
            startActivity(i1);
        } else if (name.isEmpty()) {
            editTextusername1.setError("Enter name");

        } else if (password.isEmpty()) {
            editTextPassword.setError("Enter valid password");
        }
        else{
            editTextemail2.setError("Enter valid mail");
        }
}
}
