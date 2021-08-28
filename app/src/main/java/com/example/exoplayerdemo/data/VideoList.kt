package com.example.exoplayerdemo.data

class VideoList: ArrayList<Video>() {
    override fun toString(): String {
        var buff = String()
        forEach{
            buff+= "${it},\n"
        }
        return buff
    }
}