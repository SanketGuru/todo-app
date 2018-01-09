package com.sanketguru.notesapp

import android.app.Application
import com.sanketguru.notesapp.di.component.AppComponent
import com.sanketguru.notesapp.di.component.DaggerAppComponent
import com.sanketguru.notesapp.di.module.AppModule

import timber.log.Timber

/**
 * Created by Sanket Gurav on 1/2/2018.
 */

class NotesApp : Application() {
    override fun onCreate() {
        super.onCreate()
        component.inject(this)
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        component.inject(this)

    }

    val component: AppComponent by lazy {
        DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
    }
}
