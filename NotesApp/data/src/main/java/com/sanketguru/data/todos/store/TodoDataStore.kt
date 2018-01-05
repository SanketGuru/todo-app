package com.sanketguru.data.todos.store

import com.sanketguru.data.todos.Todo
import io.reactivex.Observable

/**
 * Created by Sanket Gurav on 1/5/2018.
 */
interface TodoDataStore {
    fun getTodos(): Observable<List<Todo>>
}