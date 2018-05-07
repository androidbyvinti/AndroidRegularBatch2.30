package com.bmpl.mediafiles

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.MediaController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var pathOfVideo : String = "android.resource://"+packageName +"/"+R.raw.video

        videoView.setVideoPath(pathOfVideo)

        //var mediaController = MediaController(this)

        videoView.setMediaController(MediaController(this))

        videoView.start()



//        var mediaPlayer = MediaPlayer.create(this, R.raw.song1)
//
//        // MediaPlayer --> start(), pause(), stop()
//
//        playButton.setOnClickListener {
//            mediaPlayer.start() // will play music
//        }
//
//        pauseButton.setOnClickListener {
//            mediaPlayer.pause()
//        }
//
//        stopButton.setOnClickListener {
//            mediaPlayer.stop()
//        }

    }
}