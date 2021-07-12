package com.mcdev.sample

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

        btn.setOnClickListener {
            alb_btn.isSuccess()
        }
    }
}