package com.example.loanapp

import android.animation.ValueAnimator
import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.graphics.drawable.ClipDrawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import java.util.*

class Progress : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_color))
        setContentView(R.layout.activity_progress)
        val back = findViewById<ImageView>(R.id.back_arrow_SC)
        val conti = findViewById<Button>(R.id.Conti_CS)
        val random = Random()
        val randomNumber = random.nextInt(22) + 77
        animateProgressBar(randomNumber)
        back.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        conti.setOnClickListener(){
            val url = "https://www.solcredito.mx/?xc=3ddbaffe3c09ce6d82d60454630306ab11e5929e&utm_source=doaff&utm_medium=affiliate&utm_campaign=doaff_sol&xt=c14397b4a542ef6ab844f5012f4aac1c&aff_id=2608282040518300&utm_content=doaff"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }


    }
    private fun updateProgressBar(progress: Int) {
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        progressBar.progress = progress
        val drawable = progressBar.progressDrawable as LayerDrawable
        val clipDrawable = drawable.findDrawableByLayerId(android.R.id.progress) as ClipDrawable
        when {
            progress < 30 -> clipDrawable.setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN)
            progress < 60 -> clipDrawable.setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_IN)
            else -> clipDrawable.setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_IN)
        }
    }
    private fun animateProgressBar(progress: Int) {
        val percent_int = findViewById<TextView>(R.id.percent_int)
        val animator = ValueAnimator.ofInt(0, progress)
        animator.duration = 3000
        animator.addUpdateListener { valueAnimator ->
            val value = valueAnimator.animatedValue as Int
            updateProgressBar(value)
            percent_int.text = value.toString()
            val excel_text = findViewById<TextView>(R.id.excellent_score)
            val btn = findViewById<Button>(R.id.Conti_CS)

            val textView = findViewById<TextView>(R.id.percent_int)
            var color = Color.GREEN // replace this with the color you want
            val background = resources.getDrawable(R.drawable.round_background)
            when{
                value < 30-> color = Color.RED
                value < 60-> color = Color.YELLOW
                else -> color = Color.GREEN
            }
            background.setColorFilter(color, PorterDuff.Mode.SRC_IN)
            textView.background = background

            if (value>76){
                excel_text.visibility = View.VISIBLE
                btn.visibility = View.VISIBLE
            }
        }
        animator.start()
    }

}