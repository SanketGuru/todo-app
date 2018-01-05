package com.sanketguru.data.todos

import com.sanketguru.data.todos.store.TodoDataStore
import com.sanketguru.data.todos.store.TodoLocalDataStore
import com.sanketguru.domain.todos.TodoModel
import com.sanketguru.domain.todos.TodoRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Sanket Gurav on 1/5/2018.
 */
// To be used in application So it has to be istan tiatedd by Dagger
class TodoRepositoryImpl : TodoRepository {
    internal val dataStore: TodoDataStore
    internal val mapper: TodoMapper

    init {
        dataStore = TodoLocalDataStore()
        mapper = TodoMapper()
    }

    override fun getTodos(): Observable<List<TodoModel>> {
        return dataStore.getTodos().subscribeOn(Schedulers.io()).map { mapper.transform(it) }.observeOn(AndroidSchedulers.mainThread())
    }
}