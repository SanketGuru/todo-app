package com.sanketguru.notesapp.presentation.screens.main.note

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import com.sanketguru.notesapp.R
import com.sanketguru.notesapp.domain.module.NoteModel
import com.sanketguru.notesapp.domain.module.TextNote
import kotlinx.android.synthetic.main.fragment_create.*
import timber.log.Timber

/**
 * Created by Raju on 03-01-2018.
 */

class CreateFragment : Fragment(), CreateAndEditContract.View {
    var status = 0

    val presenter = CreateAndEditPresenter()

    companion object {

        val ARG_STRING = "arg1"
        val ARG_NOTE = "argNote"
        fun newInstance(arg1: String = "", note: TextNote = TextNote("")): Fragment {
            var frag = CreateFragment()
            var args = Bundle()
            with(args) {
                putString(ARG_STRING, arg1)
                putParcelable(ARG_NOTE, note)
            }
            frag.arguments = args
            return frag
        }
    }

    //3
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val note = arguments.getParcelable<TextNote>(ARG_NOTE)
        presenter.note = note

        val view = inflater?.inflate(R.layout.fragment_create, container, false)
        return view
    }


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        radioGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { radioGroup, id ->
            when (id) {
                rbPending.id -> {
                    status = NoteModel.TODO
                    //  Log.v("Say", "0")

                }
                rbInProgress.id -> {
                    status = NoteModel.IN_PROGRESS
                    // Log.v("Say","1")
                }
                rbDone.id -> {
                    status = NoteModel.DONE
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


    override fun setUpNote(note: TextNote) {
        Timber.v("This is %s Note", if (note.new) "new" else "old")
        editTextTitle.setText(note.title)
        editTextText.setText(note.text)
        setNoteStatus(note.status)
    }

    /**
     * updated radio button ui
     * */
    private fun setNoteStatus(status: Int) =
            when (status) {
                NoteModel.TODO -> rbPending.isChecked = true
                NoteModel.IN_PROGRESS -> rbInProgress.isChecked = true
                NoteModel.DONE -> rbDone.isChecked = true
                else -> Unit
            }

}
