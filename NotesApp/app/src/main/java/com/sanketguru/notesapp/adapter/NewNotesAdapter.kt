package com.sanketguru.notesapp.adapter

import android.view.View
import com.sanketguru.notesapp.R
import com.sanketguru.notesapp.models.TextNote
import com.sanketguru.notesapp.presentation.adapter.AbstractAdapter
import kotlinx.android.synthetic.main.list_child.*
import kotlinx.android.synthetic.main.list_child.view.*

/**
 * Created by Sanket Gurav on 1/5/2018.
 */
class NewNotesAdapter constructor(likeList: MutableList<TextNote>) : AbstractAdapter<TextNote>(likeList, R.layout.list_child) {
    override fun View.bind(item: TextNote) {
        tvTitle.text = item.title
    }
    }