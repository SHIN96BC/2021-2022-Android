package com.example.exintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et1;
    EditText et2;
    Button b1;
    Intent i;
    Intent i_self;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        i = new Intent(this, SubActivity.class);

        et1 = (EditText) findViewById(R.id.et1);
        et1.requestFocus();
        et2 = (EditText) findViewById(R.id.et2);

        i_self = getIntent();
        String value2 = i_self.getStringExtra("key2");
        et2.setText(value2);

        b1 = (Button) findViewById(R.id.b1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value1 = et1.getText().toString();
                //showMsg(value1);
                i.putExtra("key1", value1);
                //et1.setText("");
                startActivity(i);
                finish();
            }
        });
    }

    private void showMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}