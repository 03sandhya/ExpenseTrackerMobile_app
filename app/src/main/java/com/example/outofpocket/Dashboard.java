package com.example.outofpocket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Dashboard extends AppCompatActivity {
    Button bb1,bb2,bb3;
    TextView tv,tv1;
    DatePicker picker;
    int dataexpense;
    RelativeLayout mylayout;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        bb1=(Button)findViewById(R.id.button);
        bb2=(Button)findViewById(R.id.button1);
        bb3=(Button)findViewById(R.id.button2);
        tv=(TextView)findViewById(R.id.t1);
        mylayout=findViewById(R.id.rel);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault());
        String currentDate = dateFormat.format(calendar.getTime());

        // Set current date to TextView
        TextView currentDateTextView = findViewById(R.id.currentDateTextView);
        currentDateTextView.setText("" + currentDate);
        name=getIntent().getStringExtra("name");
        tv.setText("Hello "+name);

        bb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(getApplicationContext(),Expense.class);
                startActivity(i2);
            }
        });
        bb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               int dataexpense=getIntent().getIntExtra("Total Expenses",0);
               int dataincome=getIntent().getIntExtra("Total Income",0);
               int balance=dataincome-dataexpense;
               tv1=new TextView(getApplicationContext());
                RelativeLayout.LayoutParams layoutparams = new RelativeLayout.LayoutParams( RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                layoutparams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,RelativeLayout.TRUE);
                layoutparams.setMargins(370,400,90,200);
                tv1.setLayoutParams(layoutparams);
               tv1.setText("Total Expenses : "+dataexpense +"\n"+"Total Income : "+dataincome+"\n"+"Balance is :"+balance);
               if(dataincome> dataexpense)
               {
                   tv1.setTextColor(Color.GREEN);
               }
               else{
                   tv1.setTextColor(Color.RED);
               }
               mylayout.addView(tv1,layoutparams);


            }
        });
        bb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3=new Intent(getApplicationContext(),Income.class);
                startActivity(i3);

            }
        });
    }
}
