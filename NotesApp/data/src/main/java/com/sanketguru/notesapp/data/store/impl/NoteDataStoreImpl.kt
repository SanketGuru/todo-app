package com.sanketguru.notesapp.data.store.impl

import com.sanketguru.notesapp.apiservice.NoteServices
import com.sanketguru.notesapp.data.store.NoteDataStore

import com.sanketguru.notesapp.models.CreateNote
import com.sanketguru.notesapp.models.TextNote
import io.reactivex.Observable

/**
 * Created by Sanket Gurav on 1/22/2018.
 */
class NoteDataStoreImpl (private val noteSerrvice : NoteServices): NoteDataStore {
    override fun putNote(note: TextNote)= noteSerrvice.createNote(CreateNote(note))
}