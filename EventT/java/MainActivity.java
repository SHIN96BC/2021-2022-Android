package com.example.eventt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

// 방법 4 ( 셀프 이벤트처리, 오버라이딩 해서 직접 처리 )
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);
        et = (EditText) findViewById(R.id.et);

        /*
        // 방법 1 ( 무명 내부 클래스 ) ( 내용이 짧을 때 많이 사용 )
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "버튼클릭됨", Toast.LENGTH_SHORT).show();
            }
        });
         */
        // 방법 3 ( 제3 클래스 )
//        OutterHandler outterHandler = new OutterHandler(this);
//        btn.setOnClickListener(outterHandler);

        // 방법 2 ( 유명 내부 클래스 )
//        View.OnClickListener innerHandler = new InnerHandler();
//        btn.setOnClickListener(innerHandler);

        //방법 4 ( 셀프 이벤트처리, 오버라이딩 해서 직접 처리 )
        btn.setOnClickListener(this);
    }

    // 방법 4 ( 셀프 이벤트처리, 오버라이딩 해서 직접 처리 )
    @Override
    public void onClick(View view) {
        btn.setText("클릭됨");
        et.setText("제3 클래스 방식");
    }

/*
//     방법 2 ( 유명 내부 클래스 )
    class InnerHandler implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this, "버튼클릭됨", Toast.LENGTH_SHORT).show();

            // view 를 활용해서 버튼을 핸들링 하는 것도 가능하다. ( 이벤트가 발생한 객체만 핸들링 할 때 )
//            Button b = (Button) view;
//            b.setText("클릭됨");

            // 멤버변수로 핸들링 하는 경우
            btn.setText("클릭됨");
            et.setText("유명내부처리방식");
        }
    }*/
}

/*
// 방법 3 ( 제3 클래스 )
class OutterHandler implements View.OnClickListener{
    private MainActivity mainActivity;
    OutterHandler(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onClick(View view) {
        mainActivity.btn.setText("클릭됨");
        mainActivity.et.setText("제3 클래스 방식");
    }
}
*/