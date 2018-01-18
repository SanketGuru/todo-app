package com.sanketguru.notesapp.domain.repo

import com.sanketguru.notesapp.domain.module.TodoModel
import io.reactivex.Observable

/**
 * Created by Sanket Gurav on 1/5/2018.
 */
interface TodoRepository {
    fun getTodos() : Observable<List<TodoModel>>
}