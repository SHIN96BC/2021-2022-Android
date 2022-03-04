package com.example.exintent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {
    EditText et3;
    EditText et4;
    Button b2;
    Intent i;
    Intent i_self;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        i = new Intent(this, MainActivity.class);

        et3 = (EditText) findViewById(R.id.et3);
        et3.requestFocus();
        et4 = (EditText) findViewById(R.id.et4);

        i_self = getIntent();
        String value1 = i_self.getStringExtra("key1");
        et4.setText(value1);

        b2 = (Button) findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value2 = et3.getText().toString();
                //showMsg(value1);
                i.putExtra("key2", value2);
                startActivity(i);
                finish();
            }
        });
    }
}