package com.sanketguru.notesapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.sanketguru.notesapp.apiservice.RetrofitHelper
import com.sanketguru.notesapp.models.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.login.*
import timber.log.Timber

/**
 * Created by Bhavesh on 02-01-2018.
 */
class Login : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)


        buttonLogin.setOnClickListener { view ->
            //var usreName=   etUserName.text
            var user = User()
            with(user) {
                userName = etUserName.text.toString()
                password = etPassword.text.toString()


            }
            var retHelper = RetrofitHelper()
            retHelper.webService.login(user)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(Consumer { t ->
                        {
                            if (t.isSuccess) {
                                Timber.v("tag : %s", t.payload!!.id)
                                val intent = Intent(this@Login, MainActivity::class.java)
                                startActivity(intent)
                                finish()
                            }
                        }
                    }, Consumer { t ->
                        {

                            Timber.v("tag : %s", t.toString())
                            t.printStackTrace()

                        }
                    })


        }
    }

}