package com.sanketguru.notesapp.apiservice

import com.sanketguru.notesapp.domain.module.DeleteModel
import com.sanketguru.notesapp.models.CreateNote
import com.sanketguru.notesapp.models.ListNotesResponse
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.http.*


/**
 * Created by Bhavesh on 04-01-2018.
 */
interface NoteServices {

    @PUT("users/createnote")
    fun createNote(@Body createNote: CreateNote): Observable<ApiResponse<String>>
 @DELETE("note")
    fun deletNote(@Body createNote: DeleteModel): Observable<ApiResponse<String>>

    @GET("users/notes/page/{pageNumber}/{pageSize}")
    fun listRepos(@Path("pageNumber") pageNumber: Int, @Path("pageSize") pageSize: Int = 15): Flowable<ApiResponse<ListNotesResponse>>
}