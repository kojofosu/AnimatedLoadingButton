package com.mcdev.sample

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.mcdev.animatedloadingbutton.ALBButton
import com.mcdev.animatedloadingbutton.OnClickListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sBtn = findViewById<Button>(R.id.s_btn)
        val eBtn = findViewById<Button>(R.id.e_btn)
        val albButton = findViewById<ALBButton>(R.id.alb_btn)

        albButton.setLoadingTextColor(Color.WHITE)
        albButton.setLoadingText("Loading...")

        albButton.setErrorText("Failed.")

        albButton.setOnClickListener(object: OnClickListener{
            override fun onClick(view: View) {
                Toast.makeText(this@MainActivity, "End point" , Toast.LENGTH_LONG).show()
            }

        })

        sBtn.setOnClickListener {
            albButton.isSuccess()
        }

        eBtn.setOnClickListener {
            albButton.isError()
        }
    }
}