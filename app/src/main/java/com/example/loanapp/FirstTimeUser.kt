package com.example.loanapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


class FirstTimeUser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_time_user)
        supportActionBar?.hide()

        window.setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_color))
        var name = findViewById<EditText>(R.id.name)
        var img_man = findViewById<ImageView>(R.id.img_man)
        var btn_submit = findViewById<Button>(R.id.btn_conti)
        var man_txt = findViewById<TextView>(R.id.text_selected_men)
        var woman_txt = findViewById<TextView>(R.id.text_selected_women)

        var img_woman = findViewById<ImageView>(R.id.img_woman)
        img_man.setOnClickListener(){
            man_txt.text = "Man"
            woman_txt.text= ""
        }
        img_woman.setOnClickListener(){
            man_txt.text = ""
            woman_txt.text= "Women"
        }

        btn_submit.setOnClickListener(){
            if (name.text.toString()==""){
                Toast.makeText(this, "Enter you name first...",Toast.LENGTH_SHORT).show()
            }
            else {
                //Saving in sharedPreference
                val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString("name", name.text.toString())
                editor.apply()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

    }
}