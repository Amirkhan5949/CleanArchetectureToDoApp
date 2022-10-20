package com.example.cleanarchtecturetodoapp.di

import android.app.Application
import androidx.room.Room
import com.example.cleanarchtecturetodoapp.features.data.data_source.NoteDataBase
import com.example.cleanarchtecturetodoapp.features.data.repository.NoteRepositoryImplementation
import com.example.cleanarchtecturetodoapp.features.domain.repository.NoteRepository
import com.example.cleanarchtecturetodoapp.features.domain.use_cases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
        fun provideNoteDataBase(app: Application) : NoteDataBase{
        return Room.databaseBuilder(app,
            NoteDataBase::class.java,
            NoteDataBase.TABLE_NAME).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(dataBase: NoteDataBase) : NoteRepository{
        return NoteRepositoryImplementation(dataBase.notedao)
    }

    @Provides
    @Singleton
    fun provideUseCases(noteRepository: NoteRepository) :NoteUseCases{
        return NoteUseCases(
            getNote = GetNote(noteRepository),
            getNotes = GetNotes(noteRepository),
            deleteNote = DeleteNote(noteRepository),
            addNote = AddNote(noteRepository)

        )
    }
}