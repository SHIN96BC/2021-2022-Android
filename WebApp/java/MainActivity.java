package com.example.webapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    WebView wv;
    Resources r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wv = (WebView) findViewById(R.id.wv);
        wv.setWebViewClient(new WebViewClient());
        wv.setWebChromeClient(new WebChromeClient()); // 창이 뜨게 하는 js 를 실행하게끔 해주는 메소드
        WebSettings setting = wv.getSettings();
        setting.setJavaScriptEnabled(true);  // 기본 js 가 실행 가능하게끔 해주는 메소드

        r = this.getResources();
//        String app_name = r.getString(R.string.app_name);
//        String hobby = r.getString(R.string.hobby);
//        showMsg("app_name: " + app_name + ", hobby: " + hobby);
        String url_daum = r.getString(R.string.url_daum);
        wv.loadUrl(url_daum);
    }

    void showMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }
}