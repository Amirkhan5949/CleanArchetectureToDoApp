package com.example.cleanarchtecturetodoapp.features.presentation.notes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanarchtecturetodoapp.features.domain.repository.NoteRepository
import com.example.cleanarchtecturetodoapp.features.domain.use_cases.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class NotesViewmodel (val noteUseCases: NoteUseCases) : ViewModel(){

private val _state = MutableLiveData<NotesState>()
//val state : State<NotesState> = _state


    fun onEvent(event: NotesEvent){
        when(event){
            is NotesEvent.Order->{

            }
            is NotesEvent.Delete->{

            }
            is NotesEvent.RestoreNote->{

            }
            is NotesEvent.ToggleOrderSection->{
            }
        }
    }
}