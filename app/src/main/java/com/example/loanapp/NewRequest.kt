package com.example.loanapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.core.content.ContextCompat

class NewRequest : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_request)
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_color))
        supportActionBar?.hide()
        val name_get = findViewById<EditText>(R.id.name_nReq)
        //get Name from shared Preference
        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        val name = sharedPreferences.getString("name", "")
        name_get.setText(name)

        val personal_btn = findViewById<Button>(R.id.personal_BTN)
        val business_btn = findViewById<Button>(R.id.business_BTN)
        val back = findViewById<ImageView>(R.id.back_arrow)
        val btn_conti = findViewById<Button>(R.id.btn_conti_Nreq)
        personal_btn.setOnClickListener(){
            personal_btn.setBackgroundResource(R.drawable.clicked)
            business_btn.setBackgroundResource(R.drawable.edit)
        }
        business_btn.setOnClickListener(){
            business_btn.setBackgroundResource(R.drawable.clicked)
            personal_btn.setBackgroundResource(R.drawable.edit)
        }
        back.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        btn_conti.setOnClickListener(){
            val intent = Intent(this, Progress::class.java)
            startActivity(intent)
        }

    }
}