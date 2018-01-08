package com.sanketguru.data.mapper

import com.sanketguru.data.repo.Todo
import com.sanketguru.domain.module.TodoModel

/**
 * Created by Sanket Gurav on 1/5/2018.
 */
class TodoMapper {
    fun transform(todos : List<Todo>) : List<TodoModel> {
        return todos.map { TodoModel(it.title, it.text, it.id) }
    }
}