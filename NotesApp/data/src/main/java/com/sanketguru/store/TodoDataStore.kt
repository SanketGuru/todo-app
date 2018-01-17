package com.sanketguru.store

import com.sanketguru.notesapp.data.repo.Todo
import io.reactivex.Observable

/**
 * Created by Sanket Gurav on 1/5/2018.
 */
interface TodoDataStore {
    fun getTodos(): Observable<List<Todo>>
}