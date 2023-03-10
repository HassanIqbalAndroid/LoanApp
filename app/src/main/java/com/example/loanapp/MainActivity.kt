package com.example.loanapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import java.time.LocalDate


class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_color))

        val name_text = findViewById<TextView>(R.id.name_text)
        val date = findViewById<TextView>(R.id.date)
        //get Name from shared Preference
        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        val name = sharedPreferences.getString("name", "")
        name_text.text = "Hello " + name
        //
        var currentDate = LocalDate.now()
        var c_day = currentDate.dayOfMonth
        var c_month = currentDate.month
        var c_year = currentDate.year
        date.text = "   ${c_day.toString()} ${c_month.toString()} ${c_year.toString()}"

        //next screens going
        val new_req = findViewById<ImageView>(R.id.new_request_logo)
        val your_score = findViewById<ImageView>(R.id.your_score_logo)
        val sp_offer = findViewById<ImageView>(R.id.special_offer_logo)
        val sm_bid = findViewById<ImageView>(R.id.smart_bid_logo)
        new_req.setOnClickListener(){
            val intent = Intent(this, NewRequest::class.java)
            startActivity(intent)
        }
        sp_offer.setOnClickListener(){
            val intent =Intent(this, SpecialOffer::class.java)
            startActivity(intent)
        }
        sm_bid.setOnClickListener(){
            val intent = Intent(this, SmartBid::class.java)
            startActivity(intent)
        }
        your_score.setOnClickListener(){
            val intent = Intent(this,Progress::class.java)
            startActivity(intent)
        }

    }
}