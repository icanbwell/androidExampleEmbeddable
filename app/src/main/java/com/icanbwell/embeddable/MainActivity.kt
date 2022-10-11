package com.icanbwell.embeddable

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.webkit.JavascriptInterface
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val mFilePath = "file:///android_asset/firstwv.html"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        webViewSample.settings.javaScriptEnabled = true
        webViewSample.addJavascriptInterface(JSBridge(this),"JSBridge")
        webViewSample.loadUrl(mFilePath)
    }

    /**
     * Receive message from webview and pass on to native.
     */
    class JSBridge(val context: Context){
        @JavascriptInterface
        fun log(message:String) {
            Log.d("JSBridge", message)
        }
    }
}