package com.example.android4.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android4.R
import com.example.android4.adapters.CountryAdapter
import com.example.android4.data.CountryItem
import com.example.android4.databinding.FragmentMainBinding
import com.example.android4.replaceFragment

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var rcView: RecyclerView
    private lateinit var adapter: CountryAdapter

    private var popularCountryList = listOf<CountryItem>(
        CountryItem("Таджикистан", R.drawable.tj),
        CountryItem("Россия", R.drawable.ru),
        CountryItem("Узбекстан", R.drawable.uzb)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        initRcView()

        binding.btnSend.setOnClickListener {
            replaceFragment(SecondFragment())
        }

        binding.cardView2.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id=tj.humo.transfer")))
        }
    }


    private fun initRcView() {
        rcView = binding.rcView
        rcView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        adapter = CountryAdapter(popularCountryList,true)
        rcView.adapter = adapter
    }


}