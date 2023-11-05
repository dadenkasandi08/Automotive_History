package com.kasandi.myappsubmission

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.kasandi.myappsubmission.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Brand>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvAutomotiveBrand.setHasFixedSize(true)

        list.addAll(getListHeroes())
        showRecyclerList()
        binding.btAbout.setOnClickListener{
            val intent = Intent(this@MainActivity, AboutActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getListHeroes(): ArrayList<Brand>{
        val dataName = resources.getStringArray(R.array.data_name)
        val dataHistory = resources.getStringArray(R.array.data_history)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val dataYear = resources.getStringArray(R.array.data_year)
        val dataFounder = resources.getStringArray(R.array.data_founder)
        val dataOwner = resources.getStringArray(R.array.data_owner)


        val listBrand = ArrayList<Brand>()

        for (i in dataName.indices){
            val brand = Brand(dataName[i], dataHistory[i], dataYear[i],dataFounder[i],dataOwner[i], dataPhoto[i])
            listBrand.add(brand)
        }
        return listBrand
    }

    private fun showRecyclerList(){
        binding.rvAutomotiveBrand.layoutManager = LinearLayoutManager(this)
        val listBrandAdapter = ListBrandAdapter(list)
        binding.rvAutomotiveBrand.adapter = listBrandAdapter
    }
}