package com.example.bcsf20a018_mad_assignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyCustomAdapter(private val mList: List<Product>) :
    RecyclerView.Adapter<MyCustomAdapter.ViewHolder>() {

    // Holds the views for adding it to image and text
    inner class ViewHolder(currentView: View) :
        RecyclerView.ViewHolder(currentView) {
        fun bind(product: Product) {
            val imageView: ImageView = itemView.findViewById(R.id.image_view)
            val nameTv: TextView = itemView.findViewById(R.id.name)
            val priceTv: TextView = itemView.findViewById(R.id.price)

            nameTv.text = product.name
            priceTv.text = product.phone.toString()
            imageView.setImageResource(product.image)
        }
    }

    // Creates new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.activity_main2,
            parent, false
        )
        return ViewHolder(view)
    }

    // Binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = mList[position]
        holder.bind(product)
    }

    // Returns the number of items in the list
    override fun getItemCount(): Int {
        return mList.size
    }
}

