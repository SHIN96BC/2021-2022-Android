package com.example.albuma;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class TouchHandler implements View.OnTouchListener{

    MainActivity a;

    TouchHandler(MainActivity a) {
        this.a = a;
    }

    float x1 = 0.0f;
    float y1 = 0.0f;
    float x2 = 0.0f;
    float y2 = 0.0f;
    float x3 = 0.0f;
    float y3 = 0.0f;
    int i = 0 ;
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == MotionEvent.ACTION_DOWN){
//            a.showMsg("눌림");
            x1 = motionEvent.getX();
            y1 = motionEvent.getY();
            Log.i("Touch DOWN(x,y):", "(" + x1 + ", " + y1 + ")");
        } else if (action == MotionEvent.ACTION_UP) {
//            a.showMsg("땜");
            x2 = motionEvent.getX();
            y2 = motionEvent.getY();
            Log.i("Touch UP(x,y):", "(" + x2 + ", " + y2 + ")");

            float value = x1 - x2;
            // 이전 또는 다음 이미지를 보여준다
            if (value > 400){
                // 다음 이미지
                a.iv.setBackgroundResource(a.IMGS[i++]);
                if(i>=a.IMGS.length) i = 0;
            } else if(value < -400) {
                // 이전 이미지
                if(i<=0) i = a.IMGS.length-1;
                a.iv.setBackgroundResource(a.IMGS[i]);
                i--;
            }
        } else if (action == MotionEvent.ACTION_MOVE) {
//            a.showMsg("움직임");
            x3 = motionEvent.getX();
            y3 = motionEvent.getY();
            Log.i("Touch MOVE(x,y):", "(" + x3 + ", " + y3 + ")");
        } else {
//            a.showMsg("멍미?");
        }


        // 계속 이벤트를 감지할때는 true
        return true;
    }
}
