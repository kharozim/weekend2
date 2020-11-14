package com.ozimos.androidpaginationapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ozimos.androidpaginationapps.adapter.ProductAdapter
import com.ozimos.androidpaginationapps.databinding.ActivityMainBinding
import com.ozimos.androidpaginationapps.fragmen.ListProduct
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val adapter by lazy { ProductAdapter(context = this) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupNavigation()

        binding.rvMain.adapter = adapter
//        binding.rvMain.layoutManager =   LinearLayoutManager(this)
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
                    Toast.makeText(this@MainActivity, response.message(), Toast.LENGTH_SHORT)
                        .show()
                }
            }

            override fun onFailure(call: Call<List<ProductModel>>, t: Throwable) {
                t.printStackTrace()

                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
            }

        })


    }

    private fun setupNavigation() {
        val navView: BottomNavigationView = findViewById(R.id.bnv_main)
        navView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_list -> {
                    Toast.makeText(this, "List selected", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_kerangjang -> {
                    Toast.makeText(this, "chart selected", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> true
            }
        }
    }

//    private fun changeFragment(fragment: Fragment) {
//        supportFragmentManager.beginTransaction().replace(R.id.f1_main, fragment).commit()
//    }
}