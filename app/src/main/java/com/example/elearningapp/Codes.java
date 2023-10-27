package com.example.elearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Codes extends AppCompatActivity {

    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codes);


        WebView webView=findViewById(R.id.webview);

        Intent intent=getIntent();
        String name=intent.getStringExtra("Name");


if(name.equals("Data Structure and algo")){
    url="https://leetcode.com/playground/new/empty";
} else if (name.equals("Java Programing")) {
    url="https://www.w3schools.com/java/tryjava.asp?filename=demo_compiler";
}
else if (name.equals("Operating System")) {
    url="https://www.tutorialspoint.com/execute_bash_online.php";
} else if (name.equals("Sql")) {
    url="https://www.w3schools.com/sql/trysql.asp?filename=trysql_editor";
}

else if (name.equals("Python")) {
    url="https://www.w3schools.com/python/trypython.asp?filename=demo_compiler";
}

webView.loadUrl(url);
webView.getSettings().setJavaScriptEnabled(true);
webView.setWebViewClient(new WebViewClient());

    }

}