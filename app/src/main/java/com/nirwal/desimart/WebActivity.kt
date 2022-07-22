package com.nirwal.desimart

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar

class WebActivity : AppCompatActivity() {
    lateinit var progressBar:ProgressBar
    val url:String = "https://mydukaan.io/myministore"
    lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        progressBar = findViewById(R.id.progressBar)
        initWebView()
    }

    fun initWebView() {

        webView = findViewById<WebView>(R.id.webView).apply {
            settings.javaScriptEnabled = true
            settings.domStorageEnabled = true
            settings.allowFileAccess = true
            settings.allowContentAccess = true

            webViewClient = object : WebViewClient() {
                override fun onPageStarted(
                    view: WebView, url: String,
                    favicon: Bitmap?
                ) {
                    progressBar.visibility = View.VISIBLE
                }

                override fun onPageFinished(
                    view: WebView, url: String
                ) {
                    progressBar.visibility = View.GONE
                }

                override fun onReceivedError(
                    view: WebView?,
                    request: WebResourceRequest?,
                    error: WebResourceError?
                ) {
                    view?.loadUrl("file:///android_asset/error.html")
                }
            }
        }
        webView.loadUrl(url)
    }

    override fun onBackPressed() {
        if (webView.canGoBack()){
            webView.goBack()

            }else{

            super.onBackPressed()
        }
    }
}
