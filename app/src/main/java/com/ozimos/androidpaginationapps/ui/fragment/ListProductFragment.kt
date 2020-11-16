package com.ozimos.androidpaginationapps.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.ozimos.androidpaginationapps.ProductClient
import com.ozimos.androidpaginationapps.ProductModel
import com.ozimos.androidpaginationapps.adapter.ProductAdapter
import com.ozimos.androidpaginationapps.databinding.FragmentListProductBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListProductFragment : Fragment() {

    private lateinit var binding : FragmentListProductBinding
    private val adapter by lazy { ProductAdapter(requireContext()) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListProductBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment

        binding.rvMain.adapter = adapter

        ProductClient.userService.getAllProducts().enqueue(object : Callback<List<ProductModel>> {
            override fun onResponse(
                call: Call<List<ProductModel>>,
                response: Response<List<ProductModel>>
            ) {
                if (response.isSuccessful) {
                    Log.e("TAG", "Cek data: "+ Gson().toJson(response.body()) )
                    response.body()?.let {
                        adapter.setData(it)
                    }
                } else {
                    Toast.makeText(requireContext(), response.message(), Toast.LENGTH_SHORT)
                        .show()
                }
            }

            override fun onFailure(call: Call<List<ProductModel>>, t: Throwable) {
                t.printStackTrace()

                Toast.makeText(requireContext(), t.message, Toast.LENGTH_SHORT).show()
            }

        })
        return binding.root

    }


}