package com.sanketguru.notesapp.presentation.screens.main.note

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.ListFragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import com.sanketguru.notesapp.R
import com.sanketguru.notesapp.apiservice.RetrofitHelper
import com.sanketguru.notesapp.domain.module.TextNote

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_create.*


/**
 * Created by Raju on 03-01-2018.
 */

class CreateFragment : Fragment() {
    var statu = 0


    companion object {
//        private val ARG_CAUGHT = "myFragment_caught"
        fun newInstance( arg1: String): Fragment {
            var frag = CreateFragment()
            return frag
        }
//          fun newInstance(caught: MainActivity):CreateFragment{
//              val args: Bundle = Bundle()
//              args.putSerializable(ARG_CAUGHT, caught)
//              val fragment = CreateFragment()
//              fragment.arguments = args
//              return fragment
//          }

    }


    //3
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater?.inflate(R.layout.fragment_create, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        radioGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { radioGroup, id ->
            when (id) {
                rbPending.id -> {
                    statu = 0
                    //  Log.v("Say", "0")

                }
                rbInProgress.id -> {
                    statu = 1
                    // Log.v("Say","1")
                }
                rbDone.id -> {
                    statu = 2
                    //   Log.v("Say","2")
                }
            }
     /*       button.setOnClickListener({ view ->
                var notes = TextNote()
                with(notes) {
                    title = editText.text.toString()
                    text = editText2.text.toString()
                    status = statu
                }
                var createNote = CreateNote()
                createNote.note = notes
                var retHelper = RetrofitHelper()
                var loginData = retHelper.webServiceHeader.createNote(createNote)
                loginData.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(Consumer { response ->
                            Log.v("Say", response.isSuccess.toString())
                            if (response.isSuccess) {
                                val fragmentTransaction = fragmentManager
                                        .beginTransaction()
                                val postLoginFragment = ListFragment()
                                fragmentTransaction.replace(R.id.fragment, postLoginFragment)
                                fragmentManager.popBackStack()
                                fragmentTransaction.commit()

                            }
                        }, Consumer { err -> err.printStackTrace() })


            })*/


        })
    }
}