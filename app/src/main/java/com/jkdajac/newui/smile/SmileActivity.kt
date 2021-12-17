package com.jkdajac.newui.smile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import com.bumptech.glide.Glide
import com.jkdajac.newui.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_smile.*
import kotlinx.android.synthetic.main.activity_weather.*
import kotlinx.android.synthetic.main.activity_weather.ivBackWeather

class SmileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val  w : Window = window
        w.decorView.setSystemUiVisibility(
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // скрываем нижнюю панель навигации
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY) //появляется поверх активити и исчезает
        setContentView(R.layout.activity_smile)

        ivBackSmile.setOnClickListener {
            finish()
            overridePendingTransition(R.anim.back_alpha, R.anim.back_diagonal_translate)
        }
        Glide.with(this)
            .asGif()
            .load(R.drawable.giphy)
            .into(ivBackSmile);
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
        overridePendingTransition(R.anim.back_alpha, R.anim.back_diagonal_translate)
    }
}