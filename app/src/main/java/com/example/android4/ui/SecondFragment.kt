package com.example.android4.ui
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android4.APP_ACTIVITY
import com.example.android4.replaceFragment
import com.example.android4.R
import com.example.android4.adapters.CountryAdapter
import com.example.android4.data.CountryItem
import com.example.android4.databinding.FragmentSecondBinding
import java.util.Locale


class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private lateinit var rcView:RecyclerView
    private lateinit var adapter: CountryAdapter

    private var countries = listOf<CountryItem>(
        CountryItem("Россия", R.drawable.ru),
        CountryItem("Узбекистан",R.drawable.uzb),
        CountryItem("Таджикистан",R.drawable.tj),
        CountryItem("Казахстан",R.drawable.kz),
        CountryItem("ОАЭ",R.drawable.arab),
        CountryItem("Корея",R.drawable.korea),
        CountryItem("Украина",R.drawable.ukraine),

        )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding=FragmentSecondBinding.inflate(layoutInflater,container,false)
        return (binding.root)


    }

    override fun onResume() {
        super.onResume()

        initRcView()

        binding.back.setOnClickListener {
            replaceFragment(MainFragment(),false)
        }

        binding.searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }
        })
    }

    private fun filterList(query: String?) {

        if (query!=null){
            val filteredList =ArrayList<CountryItem>()
            for (i in countries){
                if (i.name_country.lowercase(Locale.ROOT).contains(query)){
                    filteredList.add(i)
                }
            }

            if (filteredList.isEmpty()){
                Toast.makeText(APP_ACTIVITY,"Не нашлось такой страны !",Toast.LENGTH_SHORT).show()
                adapter.setFilterList(filteredList)
            }else{
                adapter.setFilterList(filteredList)
            }
        }
    }


    private fun initRcView(){
        rcView=binding.rcView
        rcView.layoutManager = LinearLayoutManager(APP_ACTIVITY)
        adapter = CountryAdapter(countries)
        rcView.adapter=adapter
    }

}