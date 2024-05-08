package com.example.android4

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android4.adapters.CountryAdapter
import com.example.android4.data.CountryItem
import com.example.android4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private var rcView:RecyclerView? = null
    private var adapter:CountryAdapter? = null

    private var popularCountryList = listOf<CountryItem>(
        CountryItem("Таджикистан", R.drawable.tj),
        CountryItem("Узбекистан", R.drawable.uzb),
        CountryItem("Россия", R.drawable.ru)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        initRcView()
    }
    override fun onResume() {
        super.onResume()

        binding?.btnSend?.setOnClickListener {
            startActivity(Intent(this,SecondActivity::class.java))
        }

        binding?.cardView1?.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=tj.humo.transfer")))
        }
    }

    private fun initRcView() {
        rcView = binding?.rcView
        rcView?.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        adapter = CountryAdapter(popularCountryList,true)
        rcView?.adapter = adapter
    }

}