package com.sanketguru.notesapp

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.login.*

/**
 * Created by Bhavesh on 02-01-2018.
 */
class Login: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)


        buttonLogin.setOnClickListener { view ->
            val intent = Intent(this@Login, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}