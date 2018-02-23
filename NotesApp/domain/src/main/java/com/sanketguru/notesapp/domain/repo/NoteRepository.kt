package com.sanketguru.notesapp.domain.repo

import com.sanketguru.notesapp.domain.module.DeleteModel
import com.sanketguru.notesapp.domain.module.NotePageModel
import com.sanketguru.notesapp.domain.module.TextNote
import io.reactivex.Flowable
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
    /**
     * Get Note page
     * */
    fun getNotesPage(pageNo : Int) : Flowable<NotePageModel>

    fun deleteNote(deleteNote : DeleteModel) : Observable<Boolean>
}