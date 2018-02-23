package com.sanketguru.notesapp.core

import android.support.v7.app.AppCompatActivity
import android.view.View


/**
 * Created by sanket on 2/22/2018.
 */
open class CommonActivity : AppCompatActivity() {
    lateinit var progressLayout: View
    fun showProgress() {
        if (progressLayout != null) progressLayout.visibility = View.VISIBLE
    }

    fun hideProgress() {
        progressLayout.visibility = View.GONE
    }
}