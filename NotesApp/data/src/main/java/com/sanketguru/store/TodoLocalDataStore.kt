package com.sanketguru.store

import com.sanketguru.data.repo.Todo
import io.reactivex.Observable

/**
 * Created by Sanket Gurav on 1/5/2018.
 */
class TodoLocalDataStore : TodoDataStore {
    override fun getTodos(): Observable<List<Todo>> {
        return Observable.fromCallable {
            listOf<Todo>(Todo("Hello", "Hello Sanket", "1"), Todo("Hello", "Hello Lal", "2"))
        }
    }
}