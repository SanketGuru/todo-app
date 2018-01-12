package com.sanketguru.notesapp

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.jakewharton.rxbinding2.view.RxView
import com.sanketguru.domain.module.UserUIErrorModel
import com.sanketguru.domain.module.UserUIModel
import kotlinx.android.synthetic.main.login.*

/**
 * Created by Bhavesh on 02-01-2018.
 */
class LoginActivity : AppCompatActivity(), LoginActivityViewModel.LoginListener {

    var ss= ClickListner()
    private lateinit var viewModel: LoginActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        viewModel = ViewModelProviders.of(this).get(LoginActivityViewModel::class.java!!)

      //RxView.clicks(buttonLogin).subscribe(ss.lis)
        buttonLogin.setOnClickListener { view -> viewModel.login(UserUIModel("", etUserName.text.toString(), etPassword.text.toString(), "")) }
        //var usreName=   etUserName.text
/*            var user = UserUIModel()
            with(user) {
                userName = etUserName.text.toString()
                password = etPassword.text.toString()


            }
            var retHelper = RetrofitHelper()
         var loginData=   retHelper.webService.login(user)
            loginData  .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(Consumer {
                        response ->
                        Log.v("Say",response.isSuccess.toString())
                        if (response.isSuccess) {
                            Log.v("Say",response.payload!!.id)
                            with(AccountDetails){
                                id=response.payload!!.id
                                userName=response.payload!!.userName
                            }

                            val intent = Intent(this@LoginActivity, MainActivity::class.java)
                                startActivity(intent)
                                finish()
                        }
                    }, Consumer { err -> err.printStackTrace()} )*/


        // }
    }

    override fun validationCheck(userUIModel: UserUIErrorModel) {
        Log.v("userNameBlank", userUIModel.userName)
        Log.v("userNamePassword", userUIModel.password)

    }
}