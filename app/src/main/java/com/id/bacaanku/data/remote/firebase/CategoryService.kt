package com.id.bacaanku.data.remote.firebase

import com.id.bacaanku.data.remote.firebase.model.Category
import com.id.bacaanku.utils.COLLECTION

object CategoryService {
    fun getAllCategory(onResult: (list: List<Category>) -> Unit) {
        Firestore.instance.collection(COLLECTION.CATEGORY)
            .get().addOnSuccessListener {
                onResult(it.toObjects(Category::class.java))
            }
    }
}