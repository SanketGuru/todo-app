package com.sanketguru.notesapp.di.component

import com.sanketguru.notesapp.LoginActivityViewModel
import com.sanketguru.notesapp.di.module.AppModule
import com.sanketguru.notesapp.di.module.RepositoryModule
import dagger.Component

/**
 * Created by Sanket Gurav on 1/9/2018.
 */
@Component(modules = [(RepositoryModule::class)])
interface RepoComPonent {
    fun inject( ss : LoginActivityViewModel )
}