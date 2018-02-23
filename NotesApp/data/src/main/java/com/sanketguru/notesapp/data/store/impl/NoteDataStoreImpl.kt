package com.sanketguru.notesapp.data.store.impl

import com.sanketguru.notesapp.apiservice.ApiResponse
import com.sanketguru.notesapp.apiservice.NoteServices
import com.sanketguru.notesapp.data.store.NoteDataStore
import com.sanketguru.notesapp.domain.module.DeleteModel

import com.sanketguru.notesapp.models.CreateNote
import com.sanketguru.notesapp.models.TextNote
import io.reactivex.Observable

/**
 * Created by Sanket Gurav on 1/22/2018.
 */
class NoteDataStoreImpl (private val noteService: NoteServices): NoteDataStore {
    override fun deleteNote(note: DeleteModel)=noteService.deletNote(note)

    override fun getNotePage(pageNo: Int)= noteService.listRepos(pageNo)

    override fun putNote(note: TextNote)= noteService.createNote(CreateNote(note))
}