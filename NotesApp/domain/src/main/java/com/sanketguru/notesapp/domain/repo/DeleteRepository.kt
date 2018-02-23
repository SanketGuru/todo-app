package com.sanketguru.notesapp.domain.repo

import com.sanketguru.notesapp.domain.module.DeleteModel
import io.reactivex.Observable

/**
 * Created by Raju on 23-02-2018.
 */
interface DeleteRepository {
    fun login(user: DeleteModel): Observable<DeleteModel>
}