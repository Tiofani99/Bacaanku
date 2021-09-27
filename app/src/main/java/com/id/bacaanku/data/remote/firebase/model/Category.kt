package com.id.bacaanku.data.remote.firebase.model

import android.os.Parcelable
import com.google.firebase.firestore.DocumentId
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Category (
    @DocumentId
    var id: String? = null,

    var name: String? = null,
    var endPoint: String? = null,
    var imageUrl: String? = null,
):Parcelable
