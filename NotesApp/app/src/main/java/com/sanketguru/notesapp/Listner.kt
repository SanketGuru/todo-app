package com.sanketguru.notesapp

import android.util.Log

import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject

/**
 * Created by Sanket Gurav on 1/17/2018.
 */
import com.sanketguru.notesapp.domain.presentation.Error

class Listner(internal val lisl: PublishSubject<Error>) {

    init {
        this.lisl.subscribeActual(object : Observer<Error> {
            override fun onSubscribe(d: Disposable) {

            }

            override fun onNext(error: Error) {
                Log.v("Say", "Got it qwe" + error.message)
            }

            override fun onError(e: Throwable) {

            }

            override fun onComplete() {

            }
        })
    }
}
