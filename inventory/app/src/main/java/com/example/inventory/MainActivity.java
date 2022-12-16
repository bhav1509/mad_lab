package com.example.inventory;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {
    EditText Item, Price, Quantity;
    Button Insert, ViewAll;
    SQLiteDatabase db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Item = (EditText) findViewById(R.id.Item);
        Price = (EditText) findViewById(R.id.Price);
        Quantity = (EditText) findViewById(R.id.Quantity);
        Insert = (Button) findViewById(R.id.Insert);
        ViewAll = (Button) findViewById(R.id.ViewAll);

        Insert.setOnClickListener(this);
        ViewAll.setOnClickListener(this);

        // Creating database and table
        db = openOrCreateDatabase("Bills", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS student(item VARCHAR,price VARCHAR,quantity VARCHAR);");
    }

    public void onClick(View view) {
        // Inserting a record to the Student table
        if (view == Insert) {
            // Checking for empty fields
            if (Item.getText().toString().trim().length() == 0 ||
                    Price.getText().toString().trim().length() == 0 ||
                    Quantity.getText().toString().trim().length() == 0) {
                showMessage("Error", "Please enter all values");
                return;
            }
            db.execSQL("INSERT INTO student VALUES('" + Item.getText() + "','" + Price.getText() +
                    "','" + Quantity.getText() + "');");
            showMessage("Success", "Record added");
            clearText();
        }
        // Displaying all the records
        if (view == ViewAll) {
            Cursor c = db.rawQuery("SELECT * FROM student", null);
            if (c.getCount() == 0) {
                showMessage("Error", "No records found");
                return;
            }
            StringBuffer buffer = new StringBuffer();
            while (c.moveToNext()) {
                buffer.append("Rollno: " + c.getString(0) + "\n");
                buffer.append("Name: " + c.getString(1) + "\n");
                buffer.append("Marks: " + c.getString(2) + "\n\n");
            }
            showMessage("Student Details", buffer.toString());
        }
    }

    public void showMessage(String title, String message) {
        Builder builder = new Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void clearText() {
        Item.setText("");
        Price.setText("");
        Quantity.setText("");
        Item.requestFocus();
    }
}