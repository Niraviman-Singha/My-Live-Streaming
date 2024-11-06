package com.example.mylivestreaming

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zegocloud.uikit.prebuilt.livestreaming.ZegoUIKitPrebuiltLiveStreamingConfig
import com.zegocloud.uikit.prebuilt.livestreaming.ZegoUIKitPrebuiltLiveStreamingFragment

class LiveActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live)

        addFragment()
    }

    private fun addFragment() {
        val appID = intent.getLongExtra("appID", 0L)
        val appSign = intent.getStringExtra("appSign")
        val userID = intent.getStringExtra("userID")
        val userName = intent.getStringExtra("userName")
        val isHost = intent.getBooleanExtra("host", false)
        val liveID = intent.getStringExtra("liveID")

        val config = if (isHost) {
            ZegoUIKitPrebuiltLiveStreamingConfig.host()
        } else {
            ZegoUIKitPrebuiltLiveStreamingConfig.audience()
        }

        val fragment = ZegoUIKitPrebuiltLiveStreamingFragment.newInstance(
            appID, appSign, userID, userName, liveID, config
        )
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
            .commitNow()

    }
}