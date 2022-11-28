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
        Log.e("alp",alp)
        val resourceID =  context.resources.getIdentifier("${alp}", "drawable",context.packageName)
        holder.binding.imageRecycler.setImageResource(resourceID)
        holder.itemView.setOnClickListener {
            val itemsViewModel= productList[position]
            Toast.makeText(context, "Hello my Friend", Toast.LENGTH_SHORT).show()
            Toast.makeText(context, itemsViewModel.image2, Toast.LENGTH_SHORT).show()
            onItemClick?.invoke(itemsViewModel)

            /*
            val intent = Intent(holder.itemView.context,DetailsActivity::class.java)
            MySingleton.chosenLandmark = productList.get(position)
            holder.itemView.context.startActivity(intent)*/
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }



}