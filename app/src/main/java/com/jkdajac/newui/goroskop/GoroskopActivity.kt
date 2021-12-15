package com.jkdajac.newui.goroskop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jkdajac.newui.R

class GoroskopActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goroskop)
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
        overridePendingTransition(R.anim.back_alpha, R.anim.back_diagonal_translate)

    }
}