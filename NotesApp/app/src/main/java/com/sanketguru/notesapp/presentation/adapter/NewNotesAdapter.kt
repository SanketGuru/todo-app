package com.sanketguru.notesapp.presentation.adapter

import android.view.View
import com.sanketguru.notesapp.R
import com.sanketguru.notesapp.domain.module.TextNote
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.list_child.view.*

/**
 * Created by Sanket Gurav on 1/5/2018.
 */
class NewNotesAdapter constructor(likeList: MutableList<TextNote>) : AbstractAdapter<TextNote>(likeList, R.layout.list_child) {
   val itemClick=PublishSubject.create<TextNote>()
    override fun View.bind(position: Int, item: TextNote) {
        tvTitle.text = "${position} : ${item.title}  :  ${item.id}"

    }

    override fun onItemClick(itemView: View, position: Int) {
        if (itemClick != null) {
            itemClick.onNext(itemList[position])
        }
    }
    }