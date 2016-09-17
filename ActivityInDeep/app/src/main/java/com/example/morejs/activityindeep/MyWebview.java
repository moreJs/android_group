package com.example.morejs.activityindeep;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

/**
 * Created by morejs on 16/9/17.
 */
public class MyWebview extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_webview);


        WebView webview = (WebView)findViewById(R.id.myWebview);
        webview.loadUrl("http://www.baidu.com");


    }
}
