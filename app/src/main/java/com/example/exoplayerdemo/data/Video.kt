package com.example.exoplayerdemo.data

import com.google.gson.annotations.SerializedName

data class Video(
    @SerializedName("video_description")
    val description: String,
    @SerializedName("video_path")
    val path: String,
    @SerializedName("video_number_likes")
    val likes: Long,
    @SerializedName("video_number_comments")
    val coments: Int,
    @SerializedName("user_id")
    val userId: String,
    @SerializedName("user_name")
    val userName: String,
    @SerializedName("user_image_path")
    val userPath: String
)