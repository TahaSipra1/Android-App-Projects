package com.example.notesapp.repository

import androidx.room.Query
import com.example.notesapp.database.NoteDatabse
import com.example.notesapp.model.Note

class NoteRepository(private val db: NoteDatabse) {

    suspend fun insertNote(note: Note)=db.getNoteDao().insertNote(note)
    suspend fun deleteNote(note: Note)=db.getNoteDao().deleteNote(note)
    suspend fun updateNote(note: Note)=db.getNoteDao().updateNote(note)

    fun getAllNotes()=db.getNoteDao().getALLNotes()
    fun searchNote(query: String?)=db.getNoteDao().searchNote(query)
}