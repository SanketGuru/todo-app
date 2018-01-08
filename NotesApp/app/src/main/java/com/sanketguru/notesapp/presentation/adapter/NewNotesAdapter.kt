package com.sanketguru.notesapp.presentation.adapter

import android.view.View
import com.sanketguru.domain.module.TextNoteModle
import com.sanketguru.notesapp.R
import com.sanketguru.notesapp.presentation.adapter.AbstractAdapter
import kotlinx.android.synthetic.main.list_child.view.*

/**
 * Created by Sanket Gurav on 1/5/2018.
 */
class NewNotesAdapter constructor(likeList: MutableList<TextNoteModle>) : AbstractAdapter<TextNoteModle>(likeList, R.layout.list_child) {
    override fun View.bind(item: TextNoteModle) {
        tvTitle.text = item.title
    }
    }