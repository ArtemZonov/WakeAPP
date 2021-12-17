package com.jkdajac.newui.goroskop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import com.bumptech.glide.Glide
import com.jkdajac.newui.R
import kotlinx.android.synthetic.main.activity_goroskop.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_weather.*
import kotlinx.android.synthetic.main.activity_weather.ivBackWeather

class GoroskopActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val  w : Window = window
        w.decorView.setSystemUiVisibility(
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // скрываем нижнюю панель навигации
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY) //появляется поверх активити и исчезает
        setContentView(R.layout.activity_goroskop)

        ivBackGoroskop.setOnClickListener {
            finish()
            overridePendingTransition(R.anim.back_alpha, R.anim.back_diagonal_translate)
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
        overridePendingTransition(R.anim.back_alpha, R.anim.back_diagonal_translate)

    }
}