package com.sanketguru.notesapp.domain.repo

import com.sanketguru.notesapp.domain.module.TextNote
import io.reactivex.Observable

/**
 * Created by Sanket Gurav on 1/18/2018.
 */
interface NoteRepository {
    /**
     * Will Create  New note @param[TextNote]
     * @return [TextNote.id]
     * */
    fun putNewNote(note : TextNote) : Observable<String>
    /**
     * Will edit note note @param[TextNote]
     * this note must have [TextNote.id]non null and
     * @return [TextNote.id]
     * */
    fun patchNote(note : TextNote) : Observable<String>
}