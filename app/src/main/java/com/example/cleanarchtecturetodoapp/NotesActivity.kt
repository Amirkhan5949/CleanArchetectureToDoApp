package com.example.cleanarchtecturetodoapp

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.View
import android.view.animation.Animation
import android.view.animation.Transformation
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.cleanarchtecturetodoapp.core.ExtendFun
import com.example.cleanarchtecturetodoapp.core.ExtendFun.collapse
import com.example.cleanarchtecturetodoapp.core.ExtendFun.expand
import com.example.cleanarchtecturetodoapp.databinding.ActivityNotesBinding
import com.example.cleanarchtecturetodoapp.features.domain.model.Note
import com.example.cleanarchtecturetodoapp.features.presentation.notes.component.adapter.NoteAdapter


class NotesActivity : AppCompatActivity() {
    private lateinit var mbindinding : ActivityNotesBinding
    private lateinit var adapter : NoteAdapter
    private lateinit var mlist : List<Note>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbindinding = ActivityNotesBinding.inflate(layoutInflater)
        setContentView(mbindinding.root)

        init()

    }
    private fun init(){
       /* adapter = NoteAdapter(mlist)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        mbindinding.recyclerViewNote.layoutManager = layoutManager
        mbindinding.recyclerViewNote.adapter= adapter*/

        mbindinding.explore.setOnClickListener {
            if (mbindinding.hiddenView.visibility == View.VISIBLE) mbindinding.hiddenView.collapse()
            else mbindinding.hiddenView.expand()
        }

        mbindinding.floating.setOnClickListener {
            startActivity(Intent(this, NoteActivity::class.java))
        }
    }
}