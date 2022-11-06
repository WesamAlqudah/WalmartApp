package com.cs473de.walmartapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {

    val activitScope= CoroutineScope(Dispatchers.Main)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        activitScope.launch {
            delay(3000)
            startActivity(Intent(this@SplashActivity,LoginActivity::class.java))
            finish()
        }


    }

    override fun onStart() {
        super.onStart()

    }
}