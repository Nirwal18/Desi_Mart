package com.nirwal.desimart.ui.composable

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.util.Log
import android.view.ViewGroup
import android.webkit.*
import android.widget.LinearLayout
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.webkit.WebViewAssetLoader

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun WebPage(url:String){
    AndroidView(
        factory = {
        val view = WebView(it).apply{
            layoutParams =ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            settings.javaScriptEnabled = true
            webViewClient = object: WebViewClient(){
                override fun onPageStarted(
                    view: WebView, url: String,
                    favicon: Bitmap?) {
                    //visibility.value = true
                }

                override fun onPageFinished(
                    view: WebView, url: String) {
                   // visibility.value = false
                }
            }
            loadUrl(url)

        }
            view
                  },
        update = {
        it.loadUrl(url)
        },
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    )
}
@Preview(showBackground = true)
@Composable
fun WebPre(){
    WebPage1(add = "http://www.google.com")
}

@Composable
fun WebPage1(add:String){
    val url = remember { mutableStateOf(add)}
    val visibility = remember { mutableStateOf(true)}

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){


            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
            ) {
                AndroidView(factory = { context ->
                    val webView = WebView(context).apply {
                        layoutParams = LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.MATCH_PARENT
                        )

                        settings.javaScriptEnabled = true
                        settings.domStorageEnabled = true
                        settings.allowFileAccess = true
                        settings.allowContentAccess = true

                        webViewClient = object: WebViewClient(){
                            override fun onPageStarted(
                                view: WebView, url: String,
                                favicon: Bitmap?) {
                                visibility.value = true
                            }

                            override fun onPageFinished(
                                view: WebView, url: String) {
                                visibility.value = false
                            }

                            override fun onReceivedError(
                                view: WebView?,
                                request: WebResourceRequest?,
                                error: WebResourceError?
                            ) {
                               view?.loadUrl("file:///android_asset/error.html")
                            }

                        }

                        loadUrl(url.value)
                    }
                    webView
                },update = {
                    it.loadUrl(url.value)
                })
            }


                if (visibility.value){
                    CircularProgressIndicator(
                        color = Color(0xFF0018A8)
                    )
                }




    }

}
