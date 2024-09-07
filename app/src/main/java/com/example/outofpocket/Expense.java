package com.example.outofpocket;
import androidx.appcompat.app.AlertDialog;

import androidx.appcompat.app.AppCompatActivity;
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


public class Expense extends AppCompatActivity {
    ImageView iv1,iv2,iv3,iv4,iv5,iv6,iv7,iv8,iv9,iv10,iv11,iv12,iv13;
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9,tv10,tv11,tv12;
    EditText ed1,ed2,ed3,ed4,ed5,ed6,ed7,ed8,ed9,ed10,ed11,ed12;
    Button but1,but2;
    SQLiteDatabase db;
    AlertDialog.Builder builder;
    String ex1,ex2,ex3,ex4,ex5,ex6,ex7,ex8,ex9,ex10,ex11,ex12;
    int num1,num2,num3,num4,num5,num6,num7,num8,num9,num10,num11,num12;
    int totalexpense;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);
        iv1=(ImageView)findViewById(R.id.view1);
        iv2=(ImageView)findViewById(R.id.view2);
        iv3=(ImageView)findViewById(R.id.view3);
        iv4=(ImageView)findViewById(R.id.view4);
        iv5=(ImageView)findViewById(R.id.view5);
        iv6=(ImageView)findViewById(R.id.view6);
        iv7=(ImageView)findViewById(R.id.view7);
        iv8=(ImageView)findViewById(R.id.view8);
        iv9=(ImageView)findViewById(R.id.view9);
        iv10=(ImageView)findViewById(R.id.view10);
        iv11=(ImageView)findViewById(R.id.view11);
        iv12=(ImageView)findViewById(R.id.view12);
        iv13=(ImageView)findViewById(R.id.view13);
        tv1=(TextView)findViewById(R.id.text1);
        tv2=(TextView)findViewById(R.id.text2);
        tv3=(TextView)findViewById(R.id.text3);
        tv4=(TextView)findViewById(R.id.text4);
        tv5=(TextView)findViewById(R.id.text5);
        tv6=(TextView)findViewById(R.id.text6);
        tv7=(TextView)findViewById(R.id.text7);
        tv8=(TextView)findViewById(R.id.text8);
        tv9=(TextView)findViewById(R.id.text9);
        tv10=(TextView)findViewById(R.id.text10);
        tv11=(TextView)findViewById(R.id.text11);
        tv12=(TextView)findViewById(R.id.text12);
        ed1=(EditText)findViewById(R.id.edit1);
        ed2=(EditText)findViewById(R.id.edit2);
        ed3=(EditText)findViewById(R.id.edit3);
        ed4=(EditText)findViewById(R.id.edit4);
        ed5=(EditText)findViewById(R.id.edit5);
        ed6=(EditText)findViewById(R.id.edit6);
        ed7=(EditText)findViewById(R.id.edit7);
        ed8=(EditText)findViewById(R.id.edit8);
        ed9=(EditText)findViewById(R.id.edit9);
        ed10=(EditText)findViewById(R.id.edit10);
        ed11=(EditText)findViewById(R.id.edit11);
        ed12=(EditText)findViewById(R.id.edit12);
        but1=(Button)findViewById(R.id.sub1);
        but2=(Button)findViewById(R.id.can1);
        builder=new AlertDialog.Builder(this);
        db=openOrCreateDatabase("db1",MODE_PRIVATE,null);
        db.execSQL("create table if not exists expense(food integer, electricitybill integer,petrol integer,grocery integer,recharge integer,health integer,entertainment integer,shopping integer,transport integer,education integer,incometax integer,houserent integer )");
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ex1=ed1.getText().toString();
                num1=Integer.parseInt(ex1);
                ex2=ed2.getText().toString();
                num2=Integer.parseInt(ex2);
                ex3=ed3.getText().toString();
                num3=Integer.parseInt(ex3);
                ex4=ed4.getText().toString();
                num4=Integer.parseInt(ex4);
                ex5=ed5.getText().toString();
                num5=Integer.parseInt(ex5);
                ex6=ed6.getText().toString();
                num6=Integer.parseInt(ex6);
                ex7=ed7.getText().toString();
                num7=Integer.parseInt(ex7);
                ex8=ed8.getText().toString();
                num8=Integer.parseInt(ex8);
                ex9=ed9.getText().toString();
                num9=Integer.parseInt(ex9);
                ex10=ed10.getText().toString();
                num10=Integer.parseInt(ex10);
                ex11=ed11.getText().toString();
                num11=Integer.parseInt(ex11);
                ex12=ed12.getText().toString();
                num12=Integer.parseInt(ex12);
                int totalexpense=num1+num2+num3+num4+num5+num6+num7+num8+num9+num10+num11+num12;
                db.execSQL("insert into expense values("+num1+","+num2+","+num3+","+num4+","+num5+","+num6+","+num7+","+num8+","+num9+","+num10+","+num11+","+num12+")");
                builder.setMessage("Expenses Recorded successfully");
                builder.show();
                Intent i5=new Intent(Expense.this,Dashboard.class);
                i5.putExtra("Total Expenses",totalexpense);
                startActivity(i5);
            }
        });
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer sb=new StringBuffer();
                Cursor c=db.rawQuery("Select * from expense", null);
                while(c.moveToNext()) {
                    sb.append("food: " + c.getInt(0) + "\n");
                    sb.append("Electricity: " + c.getInt(1) + "\n");
                    sb.append("petrol: "+c.getInt(2)+ "\n");
                    sb.append("Grocery: "+c.getInt(3)+"\n");
                    sb.append("Recharge: "+c.getInt(4)+"\n");
                    sb.append("Health: "+c.getInt(5)+"\n");
                    sb.append("Entertainment: "+c.getInt(6)+"\n");
                    sb.append("Shopping: "+c.getInt(7)+"\n");
                    sb.append("Transport: "+c.getInt(8)+"\n");
                    sb.append("Education: "+c.getInt(9)+"\n");
                    sb.append("IncomeTax: "+c.getInt(10)+"\n");
                    sb.append("Rent: "+c.getInt(11)+"\n");
                }
                builder.setMessage(sb.toString());
                builder.show();

            }
        });







    }
}
