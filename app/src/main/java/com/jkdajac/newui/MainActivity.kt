package com.jkdajac.newui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import com.bumptech.glide.Glide
import com.jkdajac.newui.weather.WeatherActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clYellow.setOnClickListener {
            val intent = Intent(this, WeatherActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.diagonal_translate, R.anim.alpha)
            val animation = AnimationUtils.loadAnimation(this, R.anim.scale)
            clYellow.startAnimation(animation)
            Glide.with(this)
                .asGif()
                .load(R.drawable.restricted)
                .into(ivYellow);
        }
        clBlue.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this, R.anim.scale)
            clBlue.startAnimation(animation)
        }
    }
}