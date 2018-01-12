package com.sanketguru.notesapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.sanketguru.notesapp.apiservice.RetrofitHelper
import com.sanketguru.notesapp.models.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.login.*

/**
 * Created by Bhavesh on 08-01-2018.
 */
class Register : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)


        buttonRegister.setOnClickListener { view ->
            //var usreName=   etUserName.text
            var user = User()
            with(user) {
                userName = etUserName.text.toString()
                password = etPassword.text.toString()


            }
            var retHelper = RetrofitHelper()
            var loginData = retHelper.webService.register(user)
            loginData.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(Consumer { response ->
                        Log.v("Say", response.isSuccess.toString())
                        if (response.isSuccess) {
                            Log.v("Say", response.payload!!.id)
                            var mainActivity = Intent(this@Register, MainActivity::class.java)
                            startActivity(mainActivity)
                            finish()
                        }
                    }, Consumer { err -> err.printStackTrace() })

            /*

            { response ->
                        {
                            Log.v("Say",response.payload!!.id)
                            if (response.isSuccess) {
                               Log.v("Say",response.payload!!.id)
                            // Log.v("Logsay",);
//                                val intent = Intent(this@Login, MainActivity::class.java)
//                                startActivity(intent)
//                                finish()
                            }
                        }
                    }, { t -> {} }

             */


        }
    }

}