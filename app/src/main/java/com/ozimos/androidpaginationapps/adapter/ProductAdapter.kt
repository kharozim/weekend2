package com.ozimos.androidpaginationapps.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ozimos.androidpaginationapps.ProductModel
import com.ozimos.androidpaginationapps.databinding.ItemsProductBinding

class ProductAdapter(private var context: Context) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    //proses setData users
    private var products = listOf<ProductModel>()
    fun setData(data: List<ProductModel>) {
        products = data
        notifyDataSetChanged()

    }

    inner class ViewHolder(private var binding: ItemsProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        //proses bindData
        fun bindData(product: ProductModel) {

            binding.tvTitle.text = product.title
            binding.tvCategory.text = "category : " + product.category
            binding.tvPrice.text = "$${product.price}"
            Glide.with(binding.root).load(product.image).circleCrop()
                .into(binding.ivImage)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemsProductBinding.inflate(LayoutInflater.from(context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(products[position])
    }

    override fun getItemCount(): Int = products.size
}
