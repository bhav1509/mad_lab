package com.example.pattern;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText ee1 = (EditText) findViewById(R.id.e1);
        TextView tt1 = (TextView) findViewById(R.id.t1);
        Button b = (Button) findViewById(R.id.b1);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer n = Integer.parseInt(ee1.getText().toString());

                StringBuffer st = new StringBuffer();

                int i,j,k;
                for (i=1;i<=n;i++){
                    for(j=1;j<=n-i;j++){
                        st.append(" ");
                    }
                    for(k=1;k<=(2*i-1);k++){
                        st.append("* ");
                    }
                    st.append("\n");
                }
                tt1.setText(st);
            }

        });
    }
}
