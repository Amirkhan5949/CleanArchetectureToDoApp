package com.example.cleanarchtecturetodoapp.features.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cleanarchtecturetodoapp.features.domain.model.Note

@Database(entities = [Note::class],
            version = 1)
abstract class NoteDataBase : RoomDatabase(){
abstract val notedao : NoteDao

companion object{
     val TABLE_NAME = "note_table"
}
}

