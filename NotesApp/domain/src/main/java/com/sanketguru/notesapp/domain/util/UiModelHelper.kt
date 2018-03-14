package com.sanketguru.notesapp.domain.util

/**
 * Created by sanket on 3/7/2018.
 */

import com.sanketguru.notesapp.domain.util.ViewState.Companion.loading
import com.sanketguru.notesapp.domain.util.ViewState.Companion.success
import io.reactivex.ObservableTransformer

object UiModelHelper {
    fun <T> applyUiModel(): ObservableTransformer<T, ViewState<T>> {
        return ObservableTransformer { observable ->
            observable.map { data -> success(data) }
                    .onErrorReturn { error -> error(error) }
                    .startWith(loading())
        }
    }
}