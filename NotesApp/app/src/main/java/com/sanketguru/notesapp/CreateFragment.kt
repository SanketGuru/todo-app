package com.sanketguru.notesapp

import android.os.Bundle
import android.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.fragment_create.*


/**
 * Created by Bhavesh on 03-01-2018.
 */
class CreateFragment : Fragment() {
    var status=0
    fun newInstance(): CreateFragment {
        return CreateFragment()
    }

    /*  companion object{
          private val ARG_CAUGHT = "myFragment_caught"

          fun newInstance(caught: MainActivity):CreateFragment{
              val args: Bundle = Bundle()
              args.putSerializable(ARG_CAUGHT, caught)
              val fragment = CreateFragment()
              fragment.arguments = args
              return fragment
          }

      }*/


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
                    status=0
                  //  Log.v("Say", "0")

                }
                rbInProgress.id -> {
                    status=1
                   // Log.v("Say","1")
                }
                rbDone.id -> {
                    status=2
                 //   Log.v("Say","2")
                }
            }

        })
    }
}