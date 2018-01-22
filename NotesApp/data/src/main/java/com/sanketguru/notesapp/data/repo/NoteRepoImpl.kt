package com.sanketguru.notesapp.data.repo

import com.sanketguru.notesapp.data.mapper.NoteMapper
import com.sanketguru.notesapp.data.store.NoteDataStore
import com.sanketguru.notesapp.domain.module.TextNote
import com.sanketguru.notesapp.domain.repo.NoteRepository
import io.reactivex.Observable

/**
 * Created by Sanket Gurav on 1/22/2018.
 */
class NoteRepoImpl(private val noteStore: NoteDataStore, private val noteMapper: NoteMapper) : NoteRepository {
    override fun putNewNote(note: TextNote) = noteStore.putNote(noteMapper.transform(note)).map { (it.payload ?: "") }


    override fun patchNote(note: TextNote): Observable<String> {
        TODO()
    }
}