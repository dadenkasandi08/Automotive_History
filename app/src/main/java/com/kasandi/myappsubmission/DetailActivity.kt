package com.kasandi.myappsubmission

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.kasandi.myappsubmission.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    companion object{
        const val EXTRA_BRAND = "extra_brand"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val brand = if (Build.VERSION.SDK_INT >=33){
            intent.getParcelableExtra<Brand>(EXTRA_BRAND, Brand::class.java)
        }else{
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Brand>(EXTRA_BRAND)
        }

        if (brand!=null){
            val brandImage = brand.photo.toString()
            val brandName = brand.name.toString()
            val brandHistory = brand.history.toString()
            val brandYear = brand.year.toString()
            val brandFounder = brand.founder.toString()
            val brandOwner = brand.owner.toString()

            binding.tvBrandNameDet.text = brandName
            binding.tvBrandHistoryDetail.text = brandHistory
            binding.tvYearDet.text = brandYear
            binding.tvBrandFounder.text = "Founder : "+brandFounder
            binding.tvBrandOwner.text = "Owner/CEO : "+brandOwner

            //val req = RequestOptions().transform(CenterCrop(), RoundedCorners(16))
            Glide.with(binding.imgBrandDet.context).load(brandImage).into(binding.imgBrandDet)
        }
    }
}