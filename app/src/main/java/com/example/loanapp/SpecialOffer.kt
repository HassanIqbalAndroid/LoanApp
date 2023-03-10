package com.example.loanapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.content.ContextCompat

class SpecialOffer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_color))
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_special_offer)
        val back = findViewById<ImageView>(R.id.back_arrow_SOffer)
        val personal_credit = findViewById<ImageView>(R.id.personal_credit)
        val business_credit = findViewById<ImageView>(R.id.business_credit)
        back.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        personal_credit.setOnClickListener(){
            val url = "https://www.solcredito.mx/?xc=3ddbaffe3c09ce6d82d60454630306ab11e5929e&utm_source=doaff&utm_medium=affiliate&utm_campaign=doaff_sol&xt=c14397b4a542ef6ab844f5012f4aac1c&aff_id=2608282040518300&utm_content=doaff"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
        business_credit.setOnClickListener(){
            val url = "https://www.solcredito.mx/?xc=3ddbaffe3c09ce6d82d60454630306ab11e5929e&utm_source=doaff&utm_medium=affiliate&utm_campaign=doaff_sol&xt=c14397b4a542ef6ab844f5012f4aac1c&aff_id=2608282040518300&utm_content=doaff"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
    }
}