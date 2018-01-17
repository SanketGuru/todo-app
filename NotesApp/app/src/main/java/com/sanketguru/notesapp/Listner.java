package com.sanketguru.notesapp;

import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by Sanket Gurav on 1/17/2018.
 */
import  com.sanketguru.notesapp.domain.presentation.Error;
public class Listner {
  final  PublishSubject<Error> lisl;

    public Listner(PublishSubject<Error> lisl) {
        this.lisl = lisl;
        this.lisl.subscribeActual(new Observer<Error>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Error error) {
                Log.v("Say","Got it qwe"+ error.getMessage());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
