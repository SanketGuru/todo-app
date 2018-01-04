package com.sanketguru.notesapp.apiservice

import com.sanketguru.notesapp.models.CreateNote
import com.sanketguru.notesapp.models.User

import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.PUT

/**
 * Created by Sanket Gurav on 1/2/2018.
 */

interface LoginService {
    @POST("login")
    fun login(@Body user: User): Observable<ApiResponse<User>>


}
