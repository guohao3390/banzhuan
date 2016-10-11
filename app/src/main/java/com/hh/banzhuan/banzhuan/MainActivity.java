package com.hh.banzhuan.banzhuan;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
    private WebView webView;
    private WebSettings webSettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView= (WebView) findViewById(R.id.webView);
        webSettings=webView.getSettings();
        webSettings.setAppCacheEnabled(true);
        webSettings.setAppCacheMaxSize(100*1024*1024);
        webSettings.setAppCachePath(getExternalCacheDir().toString());
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDatabaseEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);  //无缓存时从网络加载
        webView.loadUrl("https://github.com/GeniusVJR/LearningNotes");
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                webView.loadUrl(url);
                return true;
            }
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            //重写返回键,返回到最后一个页面时退出程序,否则后退到上个页面
            if(webView.canGoBack()){
                webView.goBack();
            }else{
                finish();
            }
         return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
