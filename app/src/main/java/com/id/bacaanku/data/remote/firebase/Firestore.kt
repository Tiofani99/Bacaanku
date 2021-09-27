package com.id.bacaanku.data.remote.firebase

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

object Firestore {
    val instance = Firebase.firestore
}