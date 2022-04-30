package com.itis.android_4sem_2.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment

fun AppCompatActivity.findController(
    id: Int
) = (supportFragmentManager.findFragmentById(id) as NavHostFragment)
    .navController
