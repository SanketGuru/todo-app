package com.sanketguru.notesapp.di.module

import com.sanketguru.data.repo.UserRepositoryImpl


import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Sanket Gurav on 1/9/2018.
 */
@Module
class RepositoryModule (ss : Any)  {
    @Provides
    @Singleton
    fun getUserRepository() = "MY"
}
