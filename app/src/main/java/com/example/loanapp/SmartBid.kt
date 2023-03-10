package com.example.loanapp

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.core.content.ContextCompat

class SmartBid : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_color))
        setContentView(R.layout.activity_smart_bid)
        val back = findViewById<ImageView>(R.id.back_arrow_SBid)
        val btn = findViewById<Button>(R.id.btn_Openingoffer)
        back.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        btn.setOnClickListener(){
            val url = "https://www.solcredito.mx/?xc=3ddbaffe3c09ce6d82d60454630306ab11e5929e&utm_source=doaff&utm_medium=affiliate&utm_campaign=doaff_sol&xt=c14397b4a542ef6ab844f5012f4aac1c&aff_id=2608282040518300&utm_content=doaff"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
    }
}