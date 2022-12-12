package com.erdemofset.box.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.erdemofset.box.R
import com.erdemofset.box.databinding.RecyclerRowBinding
import com.erdemofset.box.entity.Product
import com.erdemofset.box.singleton.boxSingleton

class BasicAdapter(var context: Context,val productList : ArrayList<Product>) : RecyclerView.Adapter<BasicAdapter.BasicAdapterHolder>() {
    var onItemClick : ((Product) -> Unit)? = null
    class BasicAdapterHolder(val binding: RecyclerRowBinding): RecyclerView.ViewHolder(binding.root) {

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasicAdapterHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BasicAdapterHolder(binding)
    }

    override fun onBindViewHolder(holder: BasicAdapterHolder, position: Int) {
        val alp = productList.get(position).image
        val resourceID =  context.resources.getIdentifier("${alp}", "drawable",context.packageName)
        holder.binding.imageRecycler.setImageResource(resourceID)
        holder.itemView.setOnClickListener {
            val itemsViewModel= productList[position]

            boxSingleton.name = itemsViewModel.name
            boxSingleton.length = itemsViewModel.length
            boxSingleton.width = itemsViewModel.width
            boxSingleton.height = itemsViewModel.height
            boxSingleton.price = itemsViewModel.price
            boxSingleton.productName = itemsViewModel.productName
            boxSingleton.productInfo = itemsViewModel.productInfo
            boxSingleton.productCode = itemsViewModel.productCode
            boxSingleton.rawMaterial = itemsViewModel.rawMaterial
            boxSingleton.productNot = itemsViewModel.productNot
            boxSingleton.internalDimensions = itemsViewModel.internalDimensions
            boxSingleton.imageBasic = itemsViewModel.image
            boxSingleton.imageBasic2 = itemsViewModel.image2

            onItemClick?.invoke(itemsViewModel)

        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }



}