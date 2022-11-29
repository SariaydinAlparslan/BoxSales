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
import com.erdemofset.box.singleton.boxSingleton

class DeluxeAdapter (var context: Context, val deluxeProductList : ArrayList<Product>) : RecyclerView.Adapter<DeluxeAdapter.DeluxeAdapterHolder>() {
    var onItemClick: ((Product) -> Unit)? = null

    class DeluxeAdapterHolder(val binding: RecyclerRowDeluxeBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeluxeAdapterHolder {
        val binding = RecyclerRowDeluxeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DeluxeAdapterHolder(binding)
    }

    override fun onBindViewHolder(holder: DeluxeAdapterHolder, position: Int) {
        val alp = deluxeProductList.get(position).image
        Log.e("alp", alp)
        val resourceID = context.resources.getIdentifier("${alp}", "drawable", context.packageName)
        holder.binding.imageRecycler.setImageResource(resourceID)
        holder.itemView.setOnClickListener {
            val itemsViewModel = deluxeProductList[position]

            boxSingleton.name2 = itemsViewModel.name
            boxSingleton.length2 = itemsViewModel.length
            boxSingleton.width2 = itemsViewModel.width
            boxSingleton.height2 = itemsViewModel.height
            boxSingleton.price2 = itemsViewModel.price
            boxSingleton.productName2 = itemsViewModel.productName
            boxSingleton.productInfo2 = itemsViewModel.productInfo
            boxSingleton.productCode2 = itemsViewModel.productCode
            boxSingleton.rawMaterial2 = itemsViewModel.rawMaterial
            boxSingleton.productNot2 = itemsViewModel.productNot
            boxSingleton.internalDimensions2 = itemsViewModel.internalDimensions
            boxSingleton.imageDeluxe = itemsViewModel.image
            boxSingleton.imageDeluxe2 = itemsViewModel.image2

            Toast.makeText(context, itemsViewModel.image2, Toast.LENGTH_SHORT).show()
            onItemClick?.invoke(itemsViewModel)
        }
    }

    override fun getItemCount(): Int {
        return deluxeProductList.size
    }
}