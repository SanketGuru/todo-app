package com.sanketguru.notesapp

import android.app.Application

import timber.log.Timber

/**
 * Created by Sanket Gurav on 1/2/2018.
 */

class NotesApp : Application() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

    }
}
