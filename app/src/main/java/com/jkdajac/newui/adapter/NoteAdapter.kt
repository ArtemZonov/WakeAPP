package com.jkdajac.newui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jkdajac.newui.MyIntentConstance
import com.jkdajac.newui.R
import com.jkdajac.newui.database.Note
import com.jkdajac.newui.note.EditNoteActivity
import com.jkdajac.newui.note.NoteActivity
import kotlinx.android.synthetic.main.item_note.view.*

class NoteAdapter(val contextA: Context,
                  val noteList: List<Note>,
                  val callback: NoteActivity
): RecyclerView.Adapter<NoteAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(contextA).inflate(R.layout.item_note, parent, false), contextA
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(noteList[position])
        holder.title?.text = noteList[position].title
        holder.content?.text = noteList[position].content
        holder.deleteItem?.setOnClickListener {
            callback.deleteItem(position)
        }
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    class ViewHolder(itemView : View, contextV: Context)  : RecyclerView.ViewHolder(itemView) {
        val context = contextV
        var title: TextView? = null
        var content: TextView? = null
        var deleteItem : ImageView? = null


        init{
            title = itemView.tvTitleItem
            content = itemView.tvContentItem
            deleteItem = itemView.ivDeleteItem
        }
        interface ItemCallback {
            fun deleteItem(index: Int)
        }

        fun setData(item: Note) {
            itemView.setOnClickListener {
                val intent = Intent(context, EditNoteActivity::class.java).apply {
                    putExtra(MyIntentConstance.I_TITLE_KEY, item.title)
                    putExtra(MyIntentConstance.I_CONTENT_KEY, item.content)
                }
                context.startActivity(intent)
            }
        }
    }
}