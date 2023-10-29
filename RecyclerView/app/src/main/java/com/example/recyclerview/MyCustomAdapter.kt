package com.example.recyclerview
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.Product
import com.example.recyclerview.R

class MyCustomAdapter(private val mList: List<Product>) :
    RecyclerView.Adapter<MyCustomAdapter.ViewHolder>() {

    //TODO: Holds the views for adding it to image and text
    inner class ViewHolder(currentView: View) : RecyclerView.ViewHolder(currentView) {
        fun bind(product: Product) {

            val imageView: ImageView = itemView.findViewById(R.id.image)
            val nameTv: TextView = itemView.findViewById(R.id.txt_name)
            val priceTv: TextView = itemView.findViewById(R.id.txt_number)

            nameTv.text = product.name
            priceTv.text = product.number.toString()
            imageView.setImageResource(product.img)
        }

    }

    //TODO: Creates new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
        return ViewHolder(view)
    }

    //TODO: Binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val product = mList[position]
        holder.bind(product)
    }

    //TODO: Returns the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }
}
