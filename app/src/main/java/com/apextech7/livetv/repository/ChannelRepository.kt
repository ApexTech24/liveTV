package com.apextech7.livetv.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.apextech7.livetv.model.Channel
import com.google.firebase.firestore.FirebaseFirestore


class ChannelRepository {
    private val db = FirebaseFirestore.getInstance()

    fun getChannels(): LiveData<List<Channel>> {
        val liveData = MutableLiveData<List<Channel>>()
        db.collection("channels").addSnapshotListener { value, error ->
            if (error == null && value != null) {
                liveData.value = value.toObjects(Channel::class.java)
            }
        }
        return liveData
    }
}