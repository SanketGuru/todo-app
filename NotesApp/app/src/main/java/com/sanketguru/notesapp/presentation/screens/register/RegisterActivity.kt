package com.sanketguru.notesapp.presentation.screens.register

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.sanketguru.notesapp.R

/**
 * Created by Bhavesh on 08-01-2018.
 */
class RegisterActivity : AppCompatActivity(), RegistrationContract.View {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)


    }

}