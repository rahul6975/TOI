package com.rahul.toi.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rahul.toi.R

class EditProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}