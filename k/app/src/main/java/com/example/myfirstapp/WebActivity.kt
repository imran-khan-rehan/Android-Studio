package com.example.myfirstapp

import android.content.Intent
import android.os.Bundle

import android.webkit.WebView
import android.widget.TextView

import androidx.activity.ComponentActivity

class WebActivity: ComponentActivity() {

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.row_item)
    val url: String? = intent.getStringExtra("URL")

    val webView: WebView = findViewById(R.id.web_view)

    if (url != null) {

        webView.loadUrl(url)

    }
}
}