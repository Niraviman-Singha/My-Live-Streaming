package com.example.mylivestreaming

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.util.Random

class MainActivity : AppCompatActivity() {
    lateinit var startLiveBtn: Button
    lateinit var joinLiveBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startLiveBtn = findViewById(R.id.startLiveBtn)
        joinLiveBtn = findViewById(R.id.jointLiveBtn)

        val appID: Long = 1149008542
        val appSign: String = "52d6d13fc14e400190e875d71ed0010e094d996d9716f2f5667189dc1c1c5ac4"

        val userID: String = generateUserID()
        val userName = userID + "_Name"
        val liveID = "test_live_id"

        startLiveBtn.setOnClickListener {
            val intent = Intent(this@MainActivity, LiveActivity::class.java)
            intent.putExtra("host", true)
            intent.putExtra("appID", appID)
            intent.putExtra("appSign", appSign)
            intent.putExtra("userID", userID)
            intent.putExtra("userName", userName)
            intent.putExtra("liveID", liveID)
            startActivity(intent)
        }

        joinLiveBtn.setOnClickListener {
            val intent = Intent(this@MainActivity, LiveActivity::class.java)
            intent.putExtra("appID", appID)
            intent.putExtra("appSign", appSign)
            intent.putExtra("userID", userID)
            intent.putExtra("userName", userName)
            intent.putExtra("liveID", liveID)
            startActivity(intent)
        }
    }

    private fun generateUserID(): String {
        val builder = StringBuilder()
        val random = Random()

        while (builder.length < 5) {
            val nextInt = random.nextInt(10)
            if (builder.length == 0 && nextInt == 0) {
                continue
            }
            builder.append(nextInt)
        }
        return builder.toString()
    }
}