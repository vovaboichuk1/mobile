package com.cricoo.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myImageView: ImageView = findViewById(R.id.imageAvatar)
        val textV: TextView = findViewById(R.id.textRead)
        val intent = Intent(this,activity_second::class.java)
        myImageView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                textV.setText("Avatar")
            }
        })
        textV.setOnClickListener {
            if (textV.text == "Avatar")
                startActivity(intent)
        }
    }
}