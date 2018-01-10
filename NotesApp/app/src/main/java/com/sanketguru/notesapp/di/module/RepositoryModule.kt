package com.sanketguru.notesapp.di.module

import android.util.Log
import com.sanketguru.data.repo.UserRepositoryImpl


import dagger.Module
import dagger.Provides


import javax.inject.Singleton

/**
 * Created by Sanket Gurav on 1/9/2018.
 */
@Module
class RepositoryModule  {
    @Provides
    fun provideUserRepo() = UserRepositoryImpl()
}
