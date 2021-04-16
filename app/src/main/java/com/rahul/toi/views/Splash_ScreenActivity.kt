package com.rahul.toi.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.rahul.toi.R

class Splash_ScreenActivity : AppCompatActivity() {

    lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash__screen)

        handler.postDelayed({
            val intent = Intent(this, HomeScreen::class.java)
            startActivity(intent)
            finish()
        }, 3000)

    }
}