package com.ozimos.androidpaginationapps.fragmen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozimos.androidpaginationapps.ProductClient
import com.ozimos.androidpaginationapps.ProductModel
import com.ozimos.androidpaginationapps.R
import com.ozimos.androidpaginationapps.adapter.ProductAdapter
import com.ozimos.androidpaginationapps.databinding.FragmentListProductBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListProduct : Fragment() {

    private val binding by lazy { FragmentListProductBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val adapter = ProductAdapter(requireContext())
        binding.rvMain.adapter = adapter

        binding.rvMain.layoutManager =   LinearLayoutManager(requireContext())
        ProductClient.userService.getAllProducts().enqueue(object : Callback<List<ProductModel>> {
            override fun onResponse(
                call: Call<List<ProductModel>>,
                response: Response<List<ProductModel>>
            ) {
                if (response.isSuccessful) {

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
        return inflater.inflate(R.layout.fragment_list_product, container, false)

    }


}