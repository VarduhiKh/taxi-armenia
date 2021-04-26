package com.example.taxi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.taxi.adapter.RecyclerViewAdapter
import com.example.taxi.model.UserDetail
import com.example.taxi.remote.RequestAPI
import com.example.taxi.remote.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RecyclerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        val recycler = findViewById<RecyclerView>(R.id.rvContacts)

        val context = this

        GlobalScope.launch(Dispatchers.Default) {
            val call = RetrofitInstance.Retrofit_Instance.retrofit.create(RequestAPI::class.java)
                .getSingleUser()
            var usersList = call?.execute()?.body()
            if (usersList == null) {
                usersList = emptyList()
            }

            withContext(Dispatchers.Main) {
                val customAdapter =
                    RecyclerViewAdapter(
                        context,
                        usersList as List<UserDetail>
                    )
                recycler.adapter = customAdapter
                recycler.layoutManager = LinearLayoutManager(context)
            }
        }
    }
}