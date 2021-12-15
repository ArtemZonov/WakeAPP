package com.jkdajac.newui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import com.bumptech.glide.Glide
import com.jkdajac.newui.news.NewsActivity
import com.jkdajac.newui.note.NoteActivity
import com.jkdajac.newui.radio.RadioActivity
import com.jkdajac.newui.smile.SmileActivity
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
                .into(ivUmbrella);
        }
        clBlue.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this, R.anim.scale)
            clBlue.startAnimation(animation)
            val intent = Intent(this, RadioActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.diagonal_translate, R.anim.alpha)
            Glide.with(this)
                .asGif()
                .load(R.drawable.radio)
                .into(ivRadio);
        }
        clPurple.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this, R.anim.scale)
            clPurple.startAnimation(animation)
            val intent = Intent(this, NoteActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.diagonal_translate, R.anim.alpha)
            Glide.with(this)
                .asGif()
                .load(R.drawable.note)
                .into(ivNote);
        }
        clGreen.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this, R.anim.scale)
            clGreen.startAnimation(animation)
            val intent = Intent(this, NewsActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.diagonal_translate, R.anim.alpha)
            Glide.with(this)
                .asGif()
                .load(R.drawable.wordpress)
                .into(ivNews);
        }
        clViolet.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this, R.anim.scale)
            clViolet.startAnimation(animation)
            val intent = Intent(this, SmileActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.diagonal_translate, R.anim.alpha)
            Glide.with(this)
                .asGif()
                .load(R.drawable.smile)
                .into(ivSmile);
        }
        clRed.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this, R.anim.scale)
            clRed.startAnimation(animation)
            val intent = Intent(this, SmileActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.diagonal_translate, R.anim.alpha)
            Glide.with(this)
                .asGif()
                .load(R.drawable.med)
                .into(ivSmile);
        }
    }
}