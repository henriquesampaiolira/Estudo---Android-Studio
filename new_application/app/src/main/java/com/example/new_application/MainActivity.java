package com.example.new_application;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView wv1;
    String url;

    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        url="file:///android_asset/aula21.html";
        wv1=(WebView) findViewById(R.id.wv);
        WebSettings configs=wv1.getSettings();
        configs.setJavaScriptEnabled(true);
        wv1.addJavascriptInterface(this,"com");
        wv1.loadUrl(url);
        wv1.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon){
                super.onPageStarted(view, url, favicon);
            }
            public void onPageFinished(WebView view, String url, Bitmap favicon){
                super.onPageFinished(view, url);
            }
        });

    }
}