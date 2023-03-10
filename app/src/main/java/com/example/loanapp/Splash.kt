package com.example.loanapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.ActionBar
import androidx.core.content.ContextCompat

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_color))

        Handler(Looper.getMainLooper()).postDelayed({
            redirect()
        },2000)
    }

    private fun redirect() {

        val PREFS_NAME = "MyPrefs"

        val settings = getSharedPreferences(PREFS_NAME, 0)

        if (settings.getBoolean("my_first_time", true)) {
            //the app is being launched for first time, do something
            var intent = Intent(this, FirstTimeUser::class.java)
            startActivity(intent)
            this.finish()

            // first time task

            // record the fact that the app has been started at least once
            settings.edit().putBoolean("my_first_time", false).commit()
        }
        else{
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}