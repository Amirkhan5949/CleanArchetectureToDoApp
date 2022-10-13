package com.example.cleanarchtecturetodoapp.features.data.data_source

import androidx.room.Database
import com.example.cleanarchtecturetodoapp.features.domain.model.Note

@Database(entities = [Note::class],
            version = 1)
abstract class NoteDataBase (noteDao: NoteDao){
abstract val notedao : NoteDao

companion object{
    private val TABLE_NAME = "note_table"
}
}

