package com.sanketguru.store

import com.sanketguru.apiservice.RetrofitHelper
import com.sanketguru.notesapp.apiservice.ApiResponse
import com.sanketguru.notesapp.models.User
import io.reactivex.Observable

/**
 * Created by Sanket Gurav on 1/8/2018.
 */
interface UserDataStore {


    fun login(user : User): Observable<ApiResponse<User>>
}