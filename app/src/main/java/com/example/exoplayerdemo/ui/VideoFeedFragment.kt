package com.example.exoplayerdemo.ui

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exoplayerdemo.R
import com.example.exoplayerdemo.data.VideoDataSource
import com.example.exoplayerdemo.databinding.FragmentVideoFeedBinding
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory
import com.google.android.exoplayer2.util.Util

class VideoFeedFragment : Fragment() {
    lateinit var binding: FragmentVideoFeedBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentVideoFeedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        VideoDataSource().loadInformation(context!!)?.let {
            binding.recycler.adapter = VideoAdapter(it)
        }
        binding.recycler.layoutManager = LinearLayoutManager(context)
    }
}