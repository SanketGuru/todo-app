package com.sanketguru.notesapp.data.store.impl

import com.sanketguru.notesapp.apiservice.NoteServices
import com.sanketguru.notesapp.data.store.NoteDataStore

import com.sanketguru.notesapp.models.CreateNote
import com.sanketguru.notesapp.models.TextNote

/**
 * Created by Sanket Gurav on 1/22/2018.
 */
class NoteDataStoreImpl (private val noteService: NoteServices): NoteDataStore {
    override fun getNotePage(pageNo: Int)= noteService.listRepos(pageNo)

    override fun putNote(note: TextNote)= noteService.createNote(CreateNote(note))
}