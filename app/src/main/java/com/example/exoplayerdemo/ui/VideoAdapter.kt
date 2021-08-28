package com.example.exoplayerdemo.ui

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exoplayerdemo.R
import com.example.exoplayerdemo.data.Video
import com.example.exoplayerdemo.data.VideoList
import com.example.exoplayerdemo.databinding.ItemVideoBinding
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory
import com.google.android.exoplayer2.util.Util

class VideoAdapter(val dataset: VideoList) : RecyclerView.Adapter<VideoAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val binding: ItemVideoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private var mPlayer: SimpleExoPlayer = SimpleExoPlayer.Builder(binding.playerView.context).build()

        fun render(video: Video) {
            initPlayer(mPlayer, binding.playerView, video.path)
        }

        private fun initPlayer(
            player: SimpleExoPlayer,
            playerView: PlayerView,
            url: String
        ) {
            // Bind the player to the view.
            player.release()
            playerView.player = player
            player.playWhenReady = true
            player.seekTo(0)
            player.prepare(buildMediaSource(playerView, url), false, false)
        }

        private fun buildMediaSource(playerView: PlayerView, url: String): MediaSource {
            val userAgent =
                Util.getUserAgent(
                    playerView.context,
                    playerView.context.getString(R.string.app_name)
                )

            val dataSourceFactory = DefaultHttpDataSourceFactory(userAgent)
            val hlsMediaSource =
                ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(Uri.parse(url))

            return hlsMediaSource
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemVideoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.render(dataset[position])
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

}