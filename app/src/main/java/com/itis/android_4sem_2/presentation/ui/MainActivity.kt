package com.itis.android_4sem_2.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.itis.android_4sem_2.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, MainFragment.newInstance())
            .commit()
    }
}
