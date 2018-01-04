package com.sanketguru.notesapp.models

import android.support.v7.util.DiffUtil

/**
 * Created by Bhavesh on 04-01-2018.
 */

class MemberDiffUtilCallback(private val mOldEmployeeList: List<Any>, private val mNewEmployeeList: List<Any>) : DiffUtil.Callback() {

    override fun getOldListSize() = mOldEmployeeList.size


    override fun getNewListSize() = mNewEmployeeList.size


    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int)
            = mOldEmployeeList[oldItemPosition].toString() === mNewEmployeeList[newItemPosition].toString()

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldEmployee = mOldEmployeeList[oldItemPosition]
        val newEmployee = mNewEmployeeList[newItemPosition]

        return mOldEmployeeList[oldItemPosition] == mNewEmployeeList[newItemPosition]
    }
}
