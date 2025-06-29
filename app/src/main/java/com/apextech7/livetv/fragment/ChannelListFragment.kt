package com.apextech7.livetv.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.apextech7.livetv.PlayerActivity
import com.apextech7.livetv.adapter.ChannelAdapter
import com.apextech7.livetv.databinding.FragmentChannelListBinding
import com.apextech7.livetv.viewmodel.ChannelViewModel


class ChannelListFragment : Fragment() {

    private lateinit var binding: FragmentChannelListBinding
    private val viewModel: ChannelViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentChannelListBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.channels.observe(viewLifecycleOwner) { channelList ->
            binding.channelRecyclerView.layoutManager = LinearLayoutManager(requireContext())
            binding.channelRecyclerView.adapter = ChannelAdapter(channelList) { channel ->
                val intent = Intent(requireContext(), PlayerActivity::class.java)
                intent.putExtra("stream_url", channel.streamUrl)
                startActivity(intent)
            }
        }

        return binding.root
    }
}
