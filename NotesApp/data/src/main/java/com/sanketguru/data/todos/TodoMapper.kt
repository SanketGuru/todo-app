package com.sanketguru.data.todos

import com.sanketguru.domain.todos.TodoModel

/**
 * Created by Sanket Gurav on 1/5/2018.
 */
class TodoMapper {
    fun transform(todos : List<Todo>) : List<TodoModel> {
        return todos.map { TodoModel(it.title, it.text, it.id) }
    }
}