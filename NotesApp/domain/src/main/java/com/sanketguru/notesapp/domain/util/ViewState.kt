package com.sanketguru.notesapp.domain.util

/**
 * Created by sanket on 3/7/2018.
 */
data class ViewState<ResultType>(var status: Boolean, var data: ResultType? = null, var message: Throwable? = null) {

    companion object {
        @JvmStatic
                /**
                 * Creates [Resource] object with `SUCCESS` status and [data].
                 */
        fun <ResultType> success(data: ResultType): ViewState<ResultType> = ViewState(false, data)

        /**
         * Creates [Resource] object with `LOADING` status to notify
         * the UI to showing loading.
         */
        @JvmStatic
        fun <ResultType> loading(): ViewState<ResultType> = ViewState(true, null, null)

        /**
         * Creates [Resource] object with `ERROR` status and [message].
         */
        @JvmStatic
        fun <ResultType> error(message: Throwable?): ViewState<ResultType> = ViewState(false, message = message)
    }
}