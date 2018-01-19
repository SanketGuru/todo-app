package com.sanketguru.notesapp.domain.module

import android.os.Parcel
import android.os.Parcelable
import com.sanketguru.notesapp.domain.util.dateRepresentation
import com.sanketguru.notesapp.domain.util.stringRepresentation
import java.text.ParseException
import java.util.Date
import kotlin.collections.ArrayList

/**
 * Created by Sanket Gurav on 1/8/2018.
 */

open class NoteModel() {

    var id = ""

    var ownerId = ""

    var title = ""

    var type = 0

    var status = 0

    var sharedWith = ArrayList<String>()

    var creationDate = Date()

    var doByDate = Date()

    var lastEdited = Date()

    val new
    get() = id.isEmpty()
    /**
     * @return id of note it uniquely identifies each Note
     * */
    override fun toString() = this.id

    companion object {
        val TODO = 0
        val IN_PROGRESS = 1
        val DONE = 2
    }
}

data class TextNote(var text: String = "") : NoteModel(), Parcelable {
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(ownerId)
        parcel.writeString(title)
        parcel.writeInt(type)
        parcel.writeInt(status)
        parcel.writeStringList(sharedWith)
        parcel.writeString(text)

        try {
            //            creationDate
            parcel.writeString(creationDate stringRepresentation DATE_FORMAT)
            //            lastEdited
            parcel.writeString(lastEdited stringRepresentation DATE_FORMAT)
            //            doByDate
            parcel.writeString(doByDate stringRepresentation DATE_FORMAT)
        } catch (pe: ParseException) {
            pe.printStackTrace()
        }
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        val DATE_FORMAT = "yyyy-MM-dd"
        val CREATOR = object : Parcelable.Creator<TextNote> {
            override fun createFromParcel(parcel: Parcel) = TextNote(parcel)


            override fun newArray(size: Int): Array<TextNote?> {
                return arrayOfNulls(size)
            }
        }
    }

    //TODO parcelise date
    constructor(parcel: Parcel) : this() {
        id = parcel.readString()
        ownerId = parcel.readString()
        title = parcel.readString()
        type = parcel.readInt()
        status = parcel.readInt()
        sharedWith = parcel.createStringArrayList()
        text = parcel.readString()
        val data = parcel.readString()

        try {

            creationDate = data dateRepresentation DATE_FORMAT

            val dataModified = parcel.readString()
            lastEdited = dataModified dateRepresentation DATE_FORMAT

            val dataOnDate = parcel.readString()
            doByDate = dataOnDate dateRepresentation DATE_FORMAT
//TODO - Call specifc exception and init date tocurrent date
        } catch (pe: ParseException) {
            pe.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}