package com.sanketguru.notesapp.domain.module

/**
 * Created by sanket on 1/18/2018.
 */
data class Error(val type: Int, val message: CharSequence) {
    companion object {
        val TOAST = 0
        val ALERT = 1
        val IN_LINE = 2
    }
}