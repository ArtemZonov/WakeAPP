package com.jkdajac.newui.note

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Toast
import com.jkdajac.newui.MyIntentConstance
import com.jkdajac.newui.R
import com.jkdajac.newui.database.AppDatabase
import com.jkdajac.newui.database.Note
import kotlinx.android.synthetic.main.activity_edit_note.*
import kotlinx.android.synthetic.main.activity_note.*

class EditNoteActivity : AppCompatActivity() {

    lateinit var noteDatabase: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val  w : Window = window
        w.decorView.setSystemUiVisibility(
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // скрываем нижнюю панель навигации
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY) //появляется поверх активити и исчезает
        setContentView(R.layout.activity_edit_note)

        getMyIntents()
        noteDatabase = AppDatabase.getDatabase(this)

        floatSaveEditNote.setOnClickListener {
            if (etTitleEdit.text.isNotEmpty() && etContentEdit.text.isNotEmpty()) {
                val title: String = etTitleEdit.text.toString()
                val content: String = etContentEdit.text.toString()


                val note = Note(title = title, content = content)
                Toast.makeText(this, "Ваша заметка записана !", Toast.LENGTH_LONG)
                    .show()
                noteDatabase.noteDao().insertNote(note)

                val intent = Intent(this, NoteActivity::class.java)
                startActivity(intent)
                val  w : Window = window
                w.decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // скрываем нижнюю панель навигации
                            or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY) //появляется поверх активити и исчезает
                finish()
            } else {
                Toast.makeText(
                    this, "Пожалуйста, заполните пустые поля !",
                    Toast.LENGTH_LONG
                ).show()
            }
            //finish()
            overridePendingTransition(R.anim.back_alpha, R.anim.back_diagonal_translate)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
        overridePendingTransition(R.anim.back_alpha, R.anim.back_diagonal_translate)

    }

    fun getMyIntents() {

        val i = intent

        if (i != null) {
            if (i.getStringExtra(MyIntentConstance.I_TITLE_KEY) != null) {
                etTitleEdit.setText(i.getStringExtra(MyIntentConstance.I_TITLE_KEY))
                etContentEdit.setText(i.getStringExtra(MyIntentConstance.I_CONTENT_KEY))
            }
        }
    }
}