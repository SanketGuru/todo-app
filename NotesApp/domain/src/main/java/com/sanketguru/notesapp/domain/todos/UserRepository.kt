package com.sanketguru.notesapp.domain.todos

import com.sanketguru.notesapp.domain.module.UserUIModel
import io.reactivex.Observable

/**
 * Created by Sanket Gurav on 1/17/2018.
 */

interface UserRepository {
    fun login(user: UserUIModel): Observable< UserUIModel>
}
