package com.jkdajac.newui.note

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.jkdajac.newui.R
import com.jkdajac.newui.adapter.NoteAdapter
import com.jkdajac.newui.database.AppDatabase
import com.jkdajac.newui.database.Note
import kotlinx.android.synthetic.main.activity_note.*

class NoteActivity : AppCompatActivity(), NoteAdapter.ViewHolder.ItemCallback {

    lateinit var adapter: NoteAdapter
    lateinit var noteDatabase: AppDatabase
    lateinit var noteList: ArrayList<Note>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val  w : Window = window
        w.decorView.setSystemUiVisibility(
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // скрываем нижнюю панель навигации
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY) //появляется поверх активити и исчезает
        setContentView(R.layout.activity_note)

        noteList = ArrayList<Note>()
        noteDatabase = AppDatabase.getDatabase(this)
        getData()
        adapter =NoteAdapter(this, noteList, this)
        rvNote.layoutManager = LinearLayoutManager(this)
        rvNote.adapter = adapter


        ivBackNote.setOnClickListener {
            finish()
            val  w : Window = window
            w.decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // скрываем нижнюю панель навигации
                        or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY) //появляется поверх активити и исчезает

            overridePendingTransition(R.anim.back_alpha, R.anim.back_diagonal_translate)
        }

        floatNote.setOnClickListener {
            val intent = Intent(this, EditNoteActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.diagonal_translate, R.anim.alpha)
        }
    }

    fun getData() {
        val wordFromDb: List<Note> = noteDatabase.noteDao().getAll()
        noteList.clear()
        noteList.addAll(wordFromDb)
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
        val  w : Window = window
        w.decorView.setSystemUiVisibility(
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // скрываем нижнюю панель навигации
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY) //появляется поверх активити и исчезает
        overridePendingTransition(R.anim.back_alpha, R.anim.back_diagonal_translate)

    }

    override fun deleteItem(index: Int) {
        val addDialog = AlertDialog.Builder(this)
        addDialog
            .setMessage("Вы действительно хотите удалить запись?")
            .setPositiveButton("Ok") { dialog, _ ->
                val note = noteList[index]
                noteDatabase.noteDao().deleteNote(note)
                getData()
                adapter.notifyDataSetChanged()
                Toast.makeText(this, "Запись удалена!", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            .setNegativeButton("Отмена") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
            .show()
    }

    override fun onResume() {
        super.onResume()
        val  w : Window = window
        w.decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // скрываем нижнюю панель навигации
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY) //появляется поверх активити и исчезает
    }
}