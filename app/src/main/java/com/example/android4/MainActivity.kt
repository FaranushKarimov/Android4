package com.example.android4

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android4.adapters.CountryAdapter
import com.example.android4.data.CountryItem
import com.example.android4.ui.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        APP_ACTIVITY=this
    }


    override fun onResume() {
        super.onResume()
        replaceFragment(MainFragment(),false)
    }
}