package com.sanketguru.notesapp.domain.module

import android.os.Parcel
import android.os.Parcelable
import java.util.Date
import kotlin.collections.ArrayList

/**
 * Created by Sanket Gurav on 1/8/2018.
 */

open class NoteModel() {

    var id = ""

    var onerid = ""

    var title = ""

    var type = 0

    var status = 0

    var sharedWith: List<String> = ArrayList()

    var creationDate = Date()

    var doByDate = Date()

    var lastEdited = Date()


    /**
     * @return id of note it uniquely identifies each Note
     * */
    override fun toString() = this.id


}

data class TextNote(var text: String = "") : NoteModel(), Parcelable {
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(onerid)
        parcel.writeString(title)
        parcel.writeInt(type)
        parcel.writeInt(status)
        parcel.writeStringList(sharedWith)
        parcel.writeString(text)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TextNote> {
        override fun createFromParcel(parcel: Parcel) = TextNote(parcel)


        override fun newArray(size: Int): Array<TextNote?> {
            return arrayOfNulls(size)
        }
    }
//TODO parcelise date
    constructor(parcel: Parcel) : this() {
        id = parcel.readString()
        onerid = parcel.readString()
        title = parcel.readString()
        type = parcel.readInt()
        status = parcel.readInt()
        sharedWith = parcel.createStringArrayList()
        text = parcel.readString()
    }
}