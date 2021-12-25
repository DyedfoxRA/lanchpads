package com.example.launchpadx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.launchpadx.ui.launchpads.LaunchpadsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, LaunchpadsFragment.newInstance())
                .commitNow()
        }
    }
}