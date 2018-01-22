package com.sanketguru.notesapp.domain.module

/**
 * Created by Bhavesh on 22-01-2018.
 */

data class RegisterError(val type: Int, val message: CharSequence) {
        companion object {
            val USER_NAME = 0
            val PASSWORD = 1
            val Success = 2
            val WebServerError = 3
        }
    }
