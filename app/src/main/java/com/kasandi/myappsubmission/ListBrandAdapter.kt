package com.kasandi.myappsubmission

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kasandi.myappsubmission.databinding.ItemRowBrandSecBinding

class ListBrandAdapter(private val listBrand: ArrayList<Brand>) : RecyclerView.Adapter<ListBrandAdapter.ListViewHolder>(){

    class ListViewHolder(var binding: ItemRowBrandSecBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowBrandSecBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listBrand.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, history, year,founder, owner, photo) = listBrand[position]
        holder.binding.tvBrandNama.text = name
        holder.binding.tvBrandSince.text = year
        //val req = RequestOptions().transform(CenterCrop(), RoundedCorners(0))

        Glide.with(holder.binding.imgBrand.context)
            .load(photo).into(holder.binding.imgBrand)

        holder.binding.cvBrand.setOnClickListener {
            val intentDetail = Intent(holder.binding.cvBrand.context, DetailActivity::class.java)
            intentDetail.putExtra("extra_brand", listBrand[holder.adapterPosition])
            holder.binding.cvBrand.context.startActivity(intentDetail)
        }
    }


}