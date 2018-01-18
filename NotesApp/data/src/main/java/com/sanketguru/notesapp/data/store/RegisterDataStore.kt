package com.sanketguru.notesapp.data.store

import com.sanketguru.notesapp.apiservice.ApiResponse
import com.sanketguru.notesapp.models.Register
import io.reactivex.Observable

/**
 * Created by Bhavesh on 18-01-2018.
 */
interface RegisterDataStore {


    fun register(user : Register): Observable<ApiResponse<Register>>

}