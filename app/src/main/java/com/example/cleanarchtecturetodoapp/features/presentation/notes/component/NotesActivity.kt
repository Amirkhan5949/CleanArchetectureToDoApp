package com.example.cleanarchtecturetodoapp.features.presentation.notes.component

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cleanarchtecturetodoapp.R
import com.example.cleanarchtecturetodoapp.databinding.ActivityNotesBinding

class NotesActivity : AppCompatActivity() {
    private lateinit var mbindinding : ActivityNotesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbindinding = ActivityNotesBinding.inflate(layoutInflater)
        setContentView(mbindinding.root)


    }
}