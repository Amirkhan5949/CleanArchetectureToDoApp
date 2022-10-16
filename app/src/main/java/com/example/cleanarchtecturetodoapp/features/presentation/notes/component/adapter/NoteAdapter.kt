package com.example.cleanarchtecturetodoapp.features.presentation.notes.component.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchtecturetodoapp.R
import com.example.cleanarchtecturetodoapp.features.domain.model.Note

class NoteAdapter(private val mList: List<Note>) : RecyclerView.Adapter<NoteAdapter.NoteAdapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteAdapterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.note_item, parent, false)
        return NoteAdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteAdapterViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class NoteAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }
}