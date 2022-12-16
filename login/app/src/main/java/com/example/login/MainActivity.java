package com.example.login;



import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText e1 = findViewById(R.id.e1);
        EditText e2 = findViewById(R.id.e2);
        EditText e3 = findViewById(R.id.e3);
        Button b1 = findViewById(R.id.b1);
        db = openOrCreateDatabase("signup", Context.MODE_PRIVATE,null);
        db.execSQL("Create table if not exists signup(username varchar,id varchar,password varchar)");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Integer i = 0;
                if(e1.getText().toString().trim().length()==0||e2.getText().toString().trim().length()==0||e3.getText().toString().trim().length()==0)
                {
                    i = 1;
                }

                db.execSQL("Insert into signup values('"+e1.getText()+"','"+e2.getText()+"','"+e3.getText()+"')");
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                if(i==0)
                {
                    builder.setTitle("Success!");
                    builder.setMessage("Registered successfully! proceeding to login page!!");
                    builder.show();
                    builder.setCancelable(true);
                    Intent it = new Intent(MainActivity.this,loginpage.class);
                    startActivity(it);
                }
                else
                {
                    builder.setTitle("Oops!Error");
                    builder.setMessage("Check details!! and click on submit");
                    builder.show();
                    builder.setCancelable(true);
                }
            }
        });
    }


}