package com.example.outofpocket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.Selection;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Income extends AppCompatActivity {
    EditText EditTextIncome1, EditTextIncome2, EditTextIncome3, EditTextIncome4;
    Button buttonSaveIncome;
    ImageView ivv1,ivv2,ivv3,ivv4;
    TextView t1,t2,t3,t4;
    SQLiteDatabase db;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);
        EditTextIncome1 = findViewById(R.id.eTIncome1);
        EditTextIncome2 = findViewById(R.id.eTIncome2);
        EditTextIncome3 = findViewById(R.id.eTIncome3);
        EditTextIncome4 = findViewById(R.id.eTIncome4);
        buttonSaveIncome = findViewById(R.id.bbIncome);
        ivv1=(ImageView)findViewById(R.id.iv1);
        ivv2=(ImageView)findViewById(R.id.iv2);
        ivv3=(ImageView)findViewById(R.id.iv3);
        ivv4=(ImageView)findViewById(R.id.iv4);
        t1=(TextView)findViewById(R.id.Income1);
        t2=(TextView) findViewById(R.id.Income2);
        t3=(TextView) findViewById(R.id.Income3);
        t4=(TextView) findViewById(R.id.Income4);
        builder=new AlertDialog.Builder(this);
        db=openOrCreateDatabase("db1",MODE_PRIVATE,null);
        db.execSQL("create table if not exists income(salary integer, rentincome integer,freelancing integer,pension integer)");


        buttonSaveIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveIncome();
            }
        });
    }
    private void saveIncome() {
        int income = Integer.parseInt(EditTextIncome1.getText().toString());
        int income1 = Integer.parseInt(EditTextIncome2.getText().toString());
        int income2 =Integer.parseInt(EditTextIncome3.getText().toString());
        int income3 = Integer.parseInt(EditTextIncome4.getText().toString());
        int incometotal=income+income1+income2+income3;
        db.execSQL("insert into income values("+income+","+income1+","+income2+","+income3+")");
        builder.setMessage("Income saved successfully");
        builder.show();
        Intent i6=new Intent(Income.this,Dashboard.class);
        i6.putExtra("Total Income",incometotal);
        startActivity(i6);



    }
}
