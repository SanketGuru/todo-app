package com.sanketguru.notesapp.di.module

import com.sanketguru.notesapp.data.repo.UserRepositoryImpl


import dagger.Module
import dagger.Provides

/**
 * Created by Sanket Gurav on 1/9/2018.
 */
@Module
class RepositoryModule  {
    @Provides
    fun provideUserRepo() = UserRepositoryImpl()
}
