package com.erdemofset.box.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.erdemofset.box.databinding.RecyclerRowBinding
import com.erdemofset.box.databinding.RecyclerRowDeluxeBinding
import com.erdemofset.box.entity.Product
import com.erdemofset.box.entity.ProductDeluxe
import com.erdemofset.box.singleton.boxSingleton

class DeluxeAdapter (var context: Context, val deluxeProductList : ArrayList<ProductDeluxe>) : RecyclerView.Adapter<DeluxeAdapter.DeluxeAdapterHolder>() {
    var onItemClick: ((ProductDeluxe) -> Unit)? = null

    class DeluxeAdapterHolder(val binding: RecyclerRowDeluxeBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeluxeAdapterHolder {
        val binding = RecyclerRowDeluxeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DeluxeAdapterHolder(binding)
    }

    override fun onBindViewHolder(holder: DeluxeAdapterHolder, position: Int) {
        val alp = deluxeProductList.get(position).image
        val resourceID = context.resources.getIdentifier("${alp}", "drawable", context.packageName)
        holder.binding.imageRecycler.setImageResource(resourceID)
        holder.itemView.setOnClickListener {

            val itemsViewsModel = deluxeProductList[position]

            boxSingleton.productCode2 = itemsViewsModel.productCode
            boxSingleton.imageDeluxe = itemsViewsModel.image

            onItemClick?.invoke(itemsViewsModel)
        }
    }

    override fun getItemCount(): Int {
        return deluxeProductList.size
    }
}