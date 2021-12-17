package com.jkdajac.newui.weather

import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.jkdajac.newui.R
import kotlinx.android.synthetic.main.activity_weather.*

class WeatherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val  w : Window = window
        w.decorView.setSystemUiVisibility(
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // скрываем нижнюю панель навигации
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY) //появляется поверх активити и исчезает
        setContentView(R.layout.activity_weather)

        ivBackWeather.setOnClickListener {
            finish()
            overridePendingTransition(R.anim.back_alpha, R.anim.back_diagonal_translate)
        }
        Glide.with(this)
            .asGif()
            .load(R.drawable.yellarro)
            .into(ivBackWeather)
        Glide.with(this)
            .asGif()
            .load(R.drawable.dojd)
            .into(ivDescriptionWeather)
        Glide.with(this)
            .asGif()
            .load(R.drawable.degrees)
            .into(ivTemperature)
        Glide.with(this)
            .asGif()
            .load(R.drawable.vlajnost)
            .into(ivHumidity)
        Glide.with(this)
            .asGif()
            .load(R.drawable.speedwind)
            .into(ivSpeedWind)
        Glide.with(this)
            .asGif()
            .load(R.drawable.wind)
            .into(ivSideWind)
        Glide.with(this)
            .asGif()
            .load(R.drawable.veroyatnost)
            .into(ivMayBeWeather)
        Glide.with(this)
            .asGif()
            .load(R.drawable.mooon)
            .into(ivMoon)
        Glide.with(this)
            .asGif()
            .load(R.drawable.prognoztwo)
            .into(ivPrognoz)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
        overridePendingTransition(R.anim.back_alpha, R.anim.back_diagonal_translate)

    }
}