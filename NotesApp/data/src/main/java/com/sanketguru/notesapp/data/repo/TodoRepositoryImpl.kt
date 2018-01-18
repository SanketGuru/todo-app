package com.sanketguru.notesapp.data.repo

import com.sanketguru.notesapp.data.mapper.TodoMapper
import com.sanketguru.notesapp.domain.module.TodoModel
import com.sanketguru.notesapp.domain.todos.TodoRepository
import com.sanketguru.notesapp.store.TodoDataStore
import com.sanketguru.notesapp.store.TodoLocalDataStore
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