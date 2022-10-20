package com.example.cleanarchtecturetodoapp.features.presentation.noteditadd

import androidx.lifecycle.*
import com.example.cleanarchtecturetodoapp.features.domain.model.InvalidNoteException
import com.example.cleanarchtecturetodoapp.features.domain.model.Note
import com.example.cleanarchtecturetodoapp.features.domain.use_cases.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteEditAddViewModel @Inject constructor(
    private val useCases: NoteUseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _note_Title = MutableLiveData(NoteTextFieldState(
        hint = "Enter Title..."
    ))

    val noteTitle : LiveData<NoteTextFieldState> = _note_Title

    private val _note_Content = MutableLiveData(NoteTextFieldState(
        hint = "Enter some content..."
    ))

    val noteContent : LiveData<NoteTextFieldState> = _note_Content

    private val _note_Color = MutableLiveData(Note.noteColors.random())

    val note_Color : MutableLiveData<Int> = _note_Color

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var currentNoteId: Int? = null


    init {
      savedStateHandle.get<Int>("noteId")?.let {noteId->
          if (noteId!=-1){
              viewModelScope.launch {
                  useCases.getNote(noteId)?.also {note->
                      currentNoteId = note.id
                      _note_Title.value= noteTitle.value?.copy(
                          text = note.title,
                          ishintVisible = false
                      )
                      _note_Content.value = noteContent.value?.copy(
                         text = note.content,
                          ishintVisible = false
                      )
                      _note_Color.value = note.color
                  }
              }
          }

      }
    }
    fun onEvent(event : AddEditNoteEvent){
        when(event){
            is AddEditNoteEvent.EnteredTitle->
                _note_Title.value =noteTitle.value?.copy(
                    text =event.value
                )

            is AddEditNoteEvent.EnteredContent->
                _note_Title.value = noteTitle.value?.copy(
                    text = event.value
                )
            is AddEditNoteEvent.ChangeColor->
                _note_Color.value = note_Color.value

            is AddEditNoteEvent.SaveNote->

                viewModelScope.launch {
                    try {
                        useCases.addNote(Note
                            (title = noteTitle.value!!.text,
                        content = noteContent.value!!.text,
                        timestamp = System.currentTimeMillis(),
                        color = note_Color.value!!,
                            id = currentNoteId
                        ))
                       _eventFlow.emit(UiEvent.SaveNote)
                    }catch (e : InvalidNoteException){
                        _eventFlow.emit(
                            UiEvent.ShowSnackbar(
                                message = e.message ?: "Couldn't save note"
                            )
                        )
                    }
                }
        }
    }
    sealed class UiEvent {
        data class ShowSnackbar(val message: String): UiEvent()
        object SaveNote: UiEvent()
    }
}