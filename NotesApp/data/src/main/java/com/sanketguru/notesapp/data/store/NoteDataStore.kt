package com.sanketguru.notesapp.data.store

import com.sanketguru.notesapp.apiservice.ApiResponse
import com.sanketguru.notesapp.domain.module.DeleteModel
import com.sanketguru.notesapp.models.ListNotesResponse
import com.sanketguru.notesapp.models.TextNote
import io.reactivex.Flowable
import io.reactivex.Observable

/**
 * Created by Sanket Gurav on 1/22/2018.
 */
interface NoteDataStore {
    fun putNote(note : TextNote) : Observable<ApiResponse<String>>
    fun getNotePage(pageNo : Int) : Flowable<ApiResponse<ListNotesResponse>>
    fun deleteNote(note: DeleteModel): Observable<ApiResponse<String>>
}