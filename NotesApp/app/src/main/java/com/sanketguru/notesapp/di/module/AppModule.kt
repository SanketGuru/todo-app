package com.sanketguru.notesapp.di.module

import com.sanketguru.notesapp.NotesApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Sanket Gurav on 1/8/2018.
 */
@Module
class AppModule(val app: NotesApp) {
    @Provides
    @Singleton
    fun provideApp() = app
}