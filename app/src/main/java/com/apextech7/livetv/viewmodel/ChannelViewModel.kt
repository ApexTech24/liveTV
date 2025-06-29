package com.apextech7.livetv.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.apextech7.livetv.model.Channel
import com.apextech7.livetv.repository.ChannelRepository

class ChannelViewModel : ViewModel() {
    private val repository = ChannelRepository()
    val channels: LiveData<List<Channel>> = repository.getChannels()
}