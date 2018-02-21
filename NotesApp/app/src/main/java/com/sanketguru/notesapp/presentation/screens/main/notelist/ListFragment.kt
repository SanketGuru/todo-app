package com.sanketguru.notesapp.presentation.screens.main.notelist


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sanketguru.notesapp.R
import com.sanketguru.notesapp.apiservice.RetrofitHelper
import com.sanketguru.notesapp.data.mapper.NoteMapper
import com.sanketguru.notesapp.data.repo.NoteRepoImpl
import com.sanketguru.notesapp.data.store.impl.NoteDataStoreImpl
import com.sanketguru.notesapp.domain.module.NotePageModel
import com.sanketguru.notesapp.presentation.adapter.NewNotesAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.list_main.*


/**
 * A placeholder fragment containing a simple view.
 */

class ListFragment : Fragment(), ListContract.View {


    val presenter = ListPresenterImpl(view = this, noteRepo = NoteRepoImpl(NoteDataStoreImpl(RetrofitHelper().noteWebService), NoteMapper()), scheduler = AndroidSchedulers.mainThread())
    override var isLoading = false
    override var isLastPage = false
    override var pageSize = 15
    override var pageNumber = 0
    override var totalCount = 0
    var lastPosition = 0
    var notesAdapter = NewNotesAdapter(mutableListOf())
    val mLayoutManager = LinearLayoutManager(activity)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.list_main, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager = mLayoutManager
        werService(1)
        recyclerView.addOnScrollListener(recyclerViewOnScrollListener)

    }

    fun werService(pageNo: Int) {
        isLoading = true
        presenter.getPage(pageNo)
        /*
        isLoading=true
        var retHelper = RetrofitHelper()
        var loginData = retHelper.noteWebService.listRepos(pageNo)
        loginData.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer { response ->
                    Log.v("Say", response.isSuccess.toString())
                    if (response.isSuccess) {

                        Log.v("Say", response.payload!!.pageNumber.toString())
                        pageNumber = response.payload!!.pageNumber
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
                    isLoading=false} })*/
    }

    override fun addNewPage(notePageModel: NotePageModel) {
        pageNumber = notePageModel.pageNumber
        //  var notesList= MutableList<TextNote>()

        //isLoading
        isLoading = false
        if (pageNumber == 2) {
            notesAdapter = NewNotesAdapter(notePageModel.listTextNote.toMutableList())
            recyclerView.adapter = notesAdapter
        } else {
            isLastPage = notePageModel.totalCount == notesAdapter.itemCount//isLastPage
            //add
            // notesAdapter.updateScrollList(notesList, if (pageNo === 0) false else true)
            notesAdapter.update(notePageModel.listTextNote,
                    if (notePageModel.pageNumber == 0) false else true)
            mLayoutManager.scrollToPosition(lastPosition)
        }
    }

    //region Pagenation
    private val recyclerViewOnScrollListener = object : RecyclerView.OnScrollListener() {

        override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)

            // later on  something

            if (isLoading) return
            val visibleItemCount = mLayoutManager.childCount
            val totalItemCount = mLayoutManager.itemCount
            val firstVisibleItemPosition = mLayoutManager.findFirstVisibleItemPosition()
            val lastVisibleItemPosition = mLayoutManager.findLastVisibleItemPosition()

//region condition
            if (!isLastPage) {
                if (visibleItemCount + firstVisibleItemPosition >= totalItemCount
                        && firstVisibleItemPosition >= 0
                        && totalItemCount >= pageSize) {
                    //    loadMoreItems();
                    lastPosition = lastVisibleItemPosition
                    werService(pageNumber)
                }
            }

            //endregion
            //  werService( pageNumber, lastVisibleItemPosition)
        }
    }
}




