package com.sanketguru.notesapp.data.repo

import com.sanketguru.notesapp.domain.module.TextNote
import com.sanketguru.notesapp.domain.repo.NoteRepository
import io.reactivex.Observable

/**
 * Created by Sanket Gurav on 1/22/2018.
 */
class NoteRepoImpl :NoteRepository {
    override fun putNewNote(note: TextNote): Observable<String> {
        TODO()
        }

    override fun patchNote(note: TextNote): Observable<String> {
        TODO()
     }
}