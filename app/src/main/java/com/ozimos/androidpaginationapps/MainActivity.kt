package com.ozimos.androidpaginationapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ozimos.androidpaginationapps.adapter.UserAdapter
import com.ozimos.androidpaginationapps.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val adapter by lazy { UserAdapter(context = this) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvMain.adapter = adapter
//        binding.rvMain.layoutManager =   LinearLayoutManager(this)
        UserClient.userService.getAllUser().enqueue(object : Callback<UserModel> {
            override fun onResponse(
                call: Call<UserModel>,
                response: Response<UserModel>
            ) {
                if (response.isSuccessful) {

                    response.body()?.let {
                        adapter.setData(it.data)
                    }
                } else {
                    Toast.makeText(this@MainActivity, response.message(), Toast.LENGTH_SHORT)
                        .show()
                }
            }

            override fun onFailure(call: Call<UserModel>, t: Throwable) {
                t.printStackTrace()

                Toast.makeText(this@MainActivity, "onFailur", Toast.LENGTH_SHORT).show()
            }

        })

    }
}