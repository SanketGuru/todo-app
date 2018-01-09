package com.sanketguru.notesapp.presentation.adapter

import android.view.View
import com.sanketguru.domain.module.TextNote
import com.sanketguru.notesapp.R
import kotlinx.android.synthetic.main.list_child.view.*

/**
 * Created by Sanket Gurav on 1/5/2018.
 */
class NewNotesAdapter constructor(likeList: MutableList<TextNote>) : AbstractAdapter<TextNote>(likeList, R.layout.list_child) {
    override fun View.bind(item: TextNote) {
        tvTitle.text = item.title
    }
    }