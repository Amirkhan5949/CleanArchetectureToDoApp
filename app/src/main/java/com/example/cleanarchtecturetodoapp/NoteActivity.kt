package com.example.cleanarchtecturetodoapp

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.cleanarchtecturetodoapp.databinding.ActivityNoteBinding
import com.example.cleanarchtecturetodoapp.features.presentation.noteditadd.AddEditNoteEvent
import com.example.cleanarchtecturetodoapp.features.presentation.noteditadd.NoteEditAddViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class NoteActivity : AppCompatActivity() {
    private lateinit var mbinding: ActivityNoteBinding
    private val viewModel : NoteEditAddViewModel by viewModels()
    private var selectedColor : Int = Color.GREEN
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding = ActivityNoteBinding.inflate(layoutInflater)
        setContentView(mbinding.root)

        init()
    }

    @SuppressLint("ResourceType")
    private fun init() {
        mbinding.main.setBackgroundColor(Color.GREEN)
        mbinding.colorGreen.strokeColor = Color.BLACK
        mbinding.colorGreen.strokeWidth = 5

        mbinding.colorGreen.setOnClickListener {
            mbinding.colorGreen.strokeColor = Color.BLACK
            mbinding.main.setBackgroundColor(Color.GREEN)
            mbinding.colorGreen.strokeWidth = 5
            mbinding.colorSaffron.strokeWidth = 0
            mbinding.colorBlue.strokeWidth = 0
            mbinding.colorTeal.strokeWidth = 0
            mbinding.colorRed.strokeWidth = 0

            selectedColor = Color.GREEN
        }

        mbinding.colorBlue.setOnClickListener {
            mbinding.colorBlue.strokeColor = Color.BLACK
            mbinding.main.setBackgroundColor(Color.BLUE)
            mbinding.colorGreen.strokeWidth = 0
            mbinding.colorSaffron.strokeWidth = 0
            mbinding.colorBlue.strokeWidth = 5
            mbinding.colorTeal.strokeWidth = 0
            mbinding.colorRed.strokeWidth = 0

            selectedColor = Color.BLUE
        }


        mbinding.colorTeal.setOnClickListener {
            mbinding.colorTeal.strokeColor = Color.BLACK
            mbinding.main.setBackgroundColor(Color.TRANSPARENT)
            mbinding.colorGreen.strokeWidth = 0
            mbinding.colorSaffron.strokeWidth = 0
            mbinding.colorBlue.strokeWidth = 0
            mbinding.colorTeal.strokeWidth = 5
            mbinding.colorRed.strokeWidth = 0

            selectedColor = Color.TRANSPARENT
        }


        mbinding.colorRed.setOnClickListener {
            mbinding.colorRed.strokeColor = Color.BLACK
            mbinding.main.setBackgroundColor(Color.RED)
            mbinding.colorGreen.strokeWidth = 0
            mbinding.colorSaffron.strokeWidth = 0
            mbinding.colorBlue.strokeWidth = 0
            mbinding.colorTeal.strokeWidth = 0
            mbinding.colorRed.strokeWidth = 5

            selectedColor = Color.RED
        }


        mbinding.colorSaffron.setOnClickListener {
            mbinding.colorSaffron.strokeColor = Color.BLACK
            mbinding.main.setBackgroundColor(Color.GRAY)
            mbinding.colorGreen.strokeWidth = 0
            mbinding.colorSaffron.strokeWidth = 5
            mbinding.colorBlue.strokeWidth = 0
            mbinding.colorTeal.strokeWidth = 0
            mbinding.colorRed.strokeWidth = 0

            selectedColor = Color.GRAY

        }

        val title = mbinding.title.text
        val content = mbinding.content.text



        viewModel.onEvent(AddEditNoteEvent.ChangeColor(selectedColor))
        viewModel.onEvent(AddEditNoteEvent.EnteredTitle(title.toString()))
        viewModel.onEvent(AddEditNoteEvent.EnteredContent(content.toString()))
        mbinding.floating.setOnClickListener{
            viewModel.onEvent(AddEditNoteEvent.SaveNote)
            finish()
        }
    }

}

