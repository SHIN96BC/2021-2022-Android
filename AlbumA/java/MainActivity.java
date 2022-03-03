package com.example.albuma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView iv;
    final static int IMGS[] = {R.mipmap.ka1, R.mipmap.ka2, R.mipmap.ka3, R.mipmap.ka4, R.mipmap.ka5, R.mipmap.ka6, R.mipmap.ka7};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = (ImageView) findViewById(R.id.iv);
       /*
        iv.setOnClickListener(new View.OnClickListener() {
            int i = 0 ;
            @Override
            public void onClick(View view) {
                iv.setBackgroundResource(IMGS[i++]);
                if(i>=IMGS.length) i = 0;
            }
        });
        */

        iv.setOnTouchListener(new TouchHandler(this));
    }

    void showMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
