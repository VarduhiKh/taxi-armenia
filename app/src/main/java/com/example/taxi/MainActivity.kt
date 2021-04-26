package com.example.taxi

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var countDownTimer: CountDownTimer? = null
        val intent = Intent(this, RecyclerActivity::class.java)
        countDownTimer = object : CountDownTimer(3000, 1000) {
            override fun onFinish() {
                startActivity(intent)
            }

            override fun onTick(millisUntilFinished: Long) {}
        }

        countDownTimer.start()
    }
}
