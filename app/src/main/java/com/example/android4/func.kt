package com.example.android4


import androidx.fragment.app.Fragment
import com.example.android4.MainActivity
import com.example.android4.R

lateinit var APP_ACTIVITY: MainActivity

fun replaceFragment(fragment: Fragment, addStack: Boolean = true) {

    if (addStack) {
        APP_ACTIVITY.supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.placeHolder, fragment)
            .commit()
    } else {
        APP_ACTIVITY.supportFragmentManager.beginTransaction()
            .replace(R.id.placeHolder, fragment)
            .commit()

    }

}