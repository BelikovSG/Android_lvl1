package com.example.helloapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = text
        textView.text = """
            Buildtype = ${BuildConfig.BUILD_TYPE}
            Flavor = ${BuildConfig.FLAVOR}
            Version code = ${BuildConfig.VERSION_CODE}
            Version name = ${BuildConfig.VERSION_NAME}
            Application ID = ${BuildConfig.APPLICATION_ID}
        """.trimIndent()
    }
}
