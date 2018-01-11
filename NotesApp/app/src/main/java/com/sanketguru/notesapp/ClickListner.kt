package com.sanketguru.notesapp

import android.util.Log

import io.reactivex.Observable
import io.reactivex.functions.Action
import io.reactivex.functions.Consumer

/**
 * Created by Sanket Gurav on 1/11/2018.
 */

class ClickListner {
    // public Action1
    var lis: Consumer<Any> = Consumer { Log.v("Say ", "I got it") }
}
