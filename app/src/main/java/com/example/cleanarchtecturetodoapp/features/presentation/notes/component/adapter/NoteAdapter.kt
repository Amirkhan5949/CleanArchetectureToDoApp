package com.example.cleanarchtecturetodoapp.features.presentation.notes.component.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchtecturetodoapp.databinding.NoteItemBinding
import com.example.cleanarchtecturetodoapp.features.domain.model.Note

class NoteAdapter(private val mList: List<Note>) : RecyclerView.Adapter<NoteAdapter.NoteAdapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteAdapterViewHolder {
        val binding = NoteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteAdapterViewHolder, position: Int) {
        with(holder) {
            binding.Notetitle.text = mList[position].title
            binding.Notecontent.text = mList[position].content
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class NoteAdapterViewHolder(val binding: NoteItemBinding) : RecyclerView.ViewHolder(binding.root){

    }
}