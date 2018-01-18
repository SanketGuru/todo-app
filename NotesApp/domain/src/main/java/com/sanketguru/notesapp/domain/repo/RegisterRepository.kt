package com.sanketguru.notesapp.domain.repo

import com.sanketguru.notesapp.domain.module.RegisterUIModel
import io.reactivex.Observable

/**
 * Created by Bhavesh on 18-01-2018.
 */
interface RegisterRepository {
    fun register(user: RegisterUIModel): Observable<RegisterUIModel>

}