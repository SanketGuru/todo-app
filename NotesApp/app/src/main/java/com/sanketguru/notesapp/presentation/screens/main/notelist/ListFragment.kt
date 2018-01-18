/*
package com.sanketguru.notesapp


import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sanketguru.notesapp.presentation.adapter.NewNotesAdapter
//import com.sanketguru.notesapp.presentation.adapter.NotesAdapter
import com.sanketguru.notesapp.apiservice.RetrofitHelper
import com.sanketguru.notesapp.models.TextNote
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.list_main.*


*/
/**
 * A placeholder fragment containing a simple view.
 *//*

class ListFragment : Fragment() {
    private var isLoading = false
    private var isLastPage = false
    var pageSize = 0
    var pagenumber = 0
    var totalcount = 0
    var notesAdapter = NewNotesAdapter(mutableListOf<TextNote>())
    val mLayoutManager = LinearLayoutManager(activity)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.list_main, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.setLayoutManager(mLayoutManager)
        werService(1, 1)
        recyclerView.addOnScrollListener(recyclerViewOnScrollListener)

    }

    fun werService(pageNo: Int, lastPosition: Int) {
        isLoading=true
        var retHelper = RetrofitHelper()
        var loginData = retHelper.webServiceHeader.listRepos(pageNo)
        loginData.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer { response ->
                    Log.v("Say", response.isSuccess.toString())
                    if (response.isSuccess) {

                        Log.v("Say", response.payload!!.pageNumber.toString())
                        pagenumber = response.payload!!.pageNumber
                        var notesList = mutableListOf<TextNote>()
                        notesList = response.payload!!.listTextNote
                        //isLoading
                        isLoading=false
                        if (pageNo === 1) {
                            notesAdapter = NewNotesAdapter(notesList)
                            recyclerView.setAdapter(notesAdapter)
                        } else {
                            isLastPage = response.payload!!.totalCount == notesAdapter.itemCount//isLastPage
                            //add
                           // notesAdapter.updateScrollList(notesList, if (pageNo === 0) false else true)
                            notesAdapter.update(notesList, if (pageNo === 0) false else true)
                            mLayoutManager.scrollToPosition(lastPosition)
                        }


                    }
                }, Consumer { err -> {err.printStackTrace()
                    isLoading=false} })
    }

    //region Pagenation
    private val recyclerViewOnScrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
        }

        override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)

            // later on  something

            if(isLoading) return
            val visibleItemCount = mLayoutManager.getChildCount()
            val totalItemCount = mLayoutManager.getItemCount()
            val firstVisibleItemPosition = mLayoutManager.findFirstVisibleItemPosition()
            val lastVisibleItemPosition = mLayoutManager.findLastVisibleItemPosition()

//region condition
            if (!isLastPage) {
                if (visibleItemCount + firstVisibleItemPosition >= totalItemCount
                        && firstVisibleItemPosition >= 0
                        && totalItemCount >= pageSize) {
                    //    loadMoreItems();

                    werService(pagenumber, lastVisibleItemPosition)
                }
            }

            //endregion
            //  werService( pagenumber, lastVisibleItemPosition)
        }
    }
}



*/
