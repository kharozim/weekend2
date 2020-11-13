package com.ozimos.androidpaginationapps.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ozimos.androidpaginationapps.DataItem
import com.ozimos.androidpaginationapps.databinding.ItemsUserBinding

class UserAdapter(private var context: Context) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    //proses setData users
    private var users = listOf<DataItem>()
    fun setData(data: List<DataItem>) {
        users = data
        notifyDataSetChanged()
    }

    inner class ViewHolder(private var binding: ItemsUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        //proses bindData
        fun bindData(user: DataItem) {
            binding.tvFullname.text = user.firstName
            binding.tvEmail.text = user.email
            Glide.with(binding.root).load(user.avatarUrl).into(binding.ivImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemsUserBinding.inflate(LayoutInflater.from(context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(users[position])
    }

    override fun getItemCount(): Int = users.size
}
