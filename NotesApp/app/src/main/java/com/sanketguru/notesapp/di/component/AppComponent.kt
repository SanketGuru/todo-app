package com.sanketguru.notesapp.di.component

import com.sanketguru.notesapp.NotesApp
import com.sanketguru.notesapp.di.module.AppModule
import com.sanketguru.notesapp.di.module.RepositoryModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Sanket Gurav on 1/8/2018.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(app: NotesApp)
}


