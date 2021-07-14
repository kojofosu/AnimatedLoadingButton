package com.mcdev.sample

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.mcdev.animatedloadingbutton.ALBButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sBtn = findViewById<Button>(R.id.s_btn)
        val eBtn = findViewById<Button>(R.id.e_btn)
        val alb_btn = findViewById<ALBButton>(R.id.alb_btn)

        alb_btn.setLoadingTextColor(Color.WHITE)
        alb_btn.setLoadingText("Loading...")

        alb_btn.setErrorText("Failed.")

        sBtn.setOnClickListener {
            alb_btn.isSuccess()
        }

        eBtn.setOnClickListener {
            alb_btn.isError()
        }
    }
}