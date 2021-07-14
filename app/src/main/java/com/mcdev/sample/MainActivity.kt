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

        val btn = findViewById<Button>(R.id.btn)
        val alb_btn = findViewById<ALBButton>(R.id.alb_btn)

        alb_btn.setLoadingBgColor(R.color.purple_200)
        alb_btn.setLoadingTextColor(Color.BLACK)
        alb_btn.setLoadingText("Loading...")

        btn.setOnClickListener {
            alb_btn.isSuccess()
        }
    }
}