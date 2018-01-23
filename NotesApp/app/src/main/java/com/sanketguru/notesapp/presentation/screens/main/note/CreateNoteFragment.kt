package com.sanketguru.notesapp.presentation.screens.main.note

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sanketguru.notesapp.OnFragmentInteractionListener
import com.sanketguru.notesapp.R
import com.sanketguru.notesapp.apiservice.RetrofitHelper
import com.sanketguru.notesapp.data.mapper.NoteMapper
import com.sanketguru.notesapp.data.repo.NoteRepoImpl
import com.sanketguru.notesapp.data.store.impl.NoteDataStoreImpl
import com.sanketguru.notesapp.domain.module.NoteModel
import com.sanketguru.notesapp.domain.module.TextNote
import com.sanketguru.notesapp.presentation.AccountDetails
import com.sanketguru.notesapp.presentation.screens.main.notelist.ListFragment
import com.sanketguru.notesapp.presentation.utils.extensions.onClick
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.fragment_create.*
import timber.log.Timber
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by Raju on 03-01-2018.
 */

class CreateFragment : Fragment(), CreateAndEditContract.View {
    //region Ui getter setter
    override var title: String
        get() = editTextTitle.text.toString().trim()
        set(value) {
            editTextTitle.setText(value)
        }
    override var text: String
        get() = editTextText.text.toString().trim()
        set(value) {
            editTextText.setText(value)
        }
    override var doByDate = Date()
    override var status = 0
        set(value) = setNoteStatus(value)
    //endregion

    private lateinit var interacter: OnFragmentInteractionListener

    val presenter = CreateAndEditPresenter(this, NoteRepoImpl(NoteDataStoreImpl(RetrofitHelper().noteWebService), NoteMapper()), AndroidSchedulers.mainThread())

    companion object {
        const val ARG_STRING = "arg1"
        const val ARG_NOTE = "argNote"
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


        val view = inflater?.inflate(R.layout.fragment_create, container, false)

        return view
    }


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val note = arguments.getParcelable<TextNote>(ARG_NOTE)
        presenter.note = note
        setUpView()


    }

    private fun setUpView() {
        radioGroup.setOnCheckedChangeListener({ radioGroup, id ->
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
        })
        button.onClick { presenter.saveNote(getNote()) }

    }

    /**this function return data from ui to a model*/
    private fun getNote() = TextNote(
            presenter.note.id,
            AccountDetails.id,
            editTextTitle.text,
            editTextText.text,
            0,
            status,
            ArrayList(),
            Date(),
            Date(),
            Date()
    )

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

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        when (context) {
            is OnFragmentInteractionListener -> interacter = context
        }
    }

    override fun goToListPage() {
        if (interacter != null) {
            val listFragment = ListFragment()
            interacter.replaceFragmentToMain(listFragment, true)
        }

    }


}
