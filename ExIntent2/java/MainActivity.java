package com.example.exintent2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    EditText et2;
    Button b1;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i = new Intent(this, SubActivity.class);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        b1 = (Button) findViewById(R.id.b1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value1 = et1.getText().toString();
                i.putExtra("key1", value1);
                et1.setText("");
                startActivityForResult(i,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int ResultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, ResultCode, data);
        if(requestCode == 0) {
            String value2 = data.getStringExtra("key2");
            et2.setText(value2);
        }
    }
}