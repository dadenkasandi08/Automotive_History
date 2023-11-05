package com.kasandi.myappsubmission

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kasandi.myappsubmission.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
//
//        val dataPhoto = resources.obtainTypedArray(R.array.data_photo).getResourceId(0,-1)
//        binding.imDeveloper.setImageResource(dataPhoto)

    }
}