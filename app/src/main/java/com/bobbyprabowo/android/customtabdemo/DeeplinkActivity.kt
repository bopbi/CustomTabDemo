package com.bobbyprabowo.android.customtabdemo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity

class DeeplinkActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        handleDeepLink(intent)
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        handleDeepLink(intent)
    }

    private fun handleDeepLink(intent: Intent?) {
        intent?.data?.let { uri: Uri ->
            if (uri.scheme == "bobby" && uri.host == "success") {
                val mainActivityIntent = Intent(this, MainActivity::class.java).apply {
                    putExtra("DEEPLINK_URI", uri.toString())
                }
                startActivity(mainActivityIntent)
                finish()
            }
        }
    }
}
