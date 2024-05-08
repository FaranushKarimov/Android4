package com.example.android4
import android.os.Bundle
import android.widget.ImageView
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android4.adapters.CountryAdapter
import com.example.android4.data.CountryItem
import com.example.android4.databinding.ActivitySecondBinding
import java.util.Locale

class SecondActivity : AppCompatActivity() {

    private var binding:ActivitySecondBinding? = null
    private var rcView:RecyclerView? = null
    private var adapter:CountryAdapter? = null

    private var countries = listOf<CountryItem>(
        CountryItem("Россия",R.drawable.ru),
        CountryItem("Узбекистан",R.drawable.uzb),
        CountryItem("Таджикистан",R.drawable.tj),
        CountryItem("Казахстан",R.drawable.kz),
        CountryItem("ОАЭ",R.drawable.arab),
        CountryItem("Корея",R.drawable.korea),
        CountryItem("Украина",R.drawable.ukraine),

        )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.back?.setOnClickListener {
            this.onBackPressed()
        }
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
                Toast.makeText(this,"Не нашлось такой страны !",Toast.LENGTH_SHORT).show()
                adapter?.setFilterList(filteredList)
            }else{
                adapter?.setFilterList(filteredList)
            }
        }
    }

    override fun onResume() {
        super.onResume()

        initRcView()
        binding?.searchView?.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

        })

    }
    private fun initRcView(){
        rcView=binding?.rcView
        rcView?.layoutManager = LinearLayoutManager(this)
        adapter = CountryAdapter(countries)
        rcView?.adapter=adapter
    }
}