package com.example.taxi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.taxi.R
import com.example.taxi.model.UserDetail

class RecyclerViewAdapter(val context: Context, val data: List<UserDetail>) :
    RecyclerView.Adapter<RecyclerViewAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.activity_recycler_row, parent, false)
        return CustomViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val currentData = data[position]
        holder.name.text = currentData.name
        holder.email.text = currentData.email
        holder.phone.text = currentData.phone
        holder.address_street.text = currentData.address.street
        holder.address_suite.text = currentData.address.suite

        holder.view.setOnClickListener{
            Toast.makeText(context, "User ID:  ${currentData.id}", Toast.LENGTH_SHORT).show()
        }
    }

    class CustomViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView
        val email: TextView
        val phone: TextView
        val address_street: TextView
        val address_suite: TextView

        init {
            name = view.findViewById(R.id.name)
            email = view.findViewById(R.id.email)
            phone = view.findViewById(R.id.tel_number)
            address_street = view.findViewById(R.id.address_street)
            address_suite = view.findViewById(R.id.address_suite)
        }
    }
}
