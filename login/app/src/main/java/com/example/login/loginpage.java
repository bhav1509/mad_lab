package com.example.login;



import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class loginpage extends AppCompatActivity {

    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        db = openOrCreateDatabase("signup", Context.MODE_PRIVATE,null);


        EditText t1 = findViewById(R.id.t1);
        EditText t2 = findViewById(R.id.t2);
        Button bb = findViewById(R.id.button);

        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor c = db.rawQuery("Select username,password from signup where username = '"+t1.getText()+"' and password = '"+t2.getText()+"'",null);
                Log.v("Cursor Object", DatabaseUtils.dumpCursorToString(c));
                if(c.moveToFirst())
                {

                    AlertDialog.Builder b1 = new AlertDialog.Builder(loginpage.this);
                    b1.setMessage("Login success");
                    b1.setTitle("Success");
                    b1.show();
                    b1.setCancelable(true);
                    Intent i = new Intent(loginpage.this,homepage.class);
                    startActivity(i);

                }
                else
                {
                    AlertDialog.Builder b1 = new AlertDialog.Builder(loginpage.this);
                    b1.setMessage("incorrect credentials");
                    b1.setTitle("error!!");
                    b1.show();
                    b1.setCancelable(true);
                }
            }
        });

    }
}