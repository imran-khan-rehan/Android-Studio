package com.example.madassignment

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.madassignment.ui.theme.MadAssignmentTheme
import com.example.madassignment.Product
import com.example.madassignment.MyCustomAdapter
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent
import android.widget.TextView
import android.widget.Toast

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_activity)

        // Getting the RecyclerView by its id
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val btn_add=findViewById<Button>(R.id.addButton)
        // This creates a vertical layout Manager
        recyclerView.layoutManager=LinearLayoutManager(this)

        // ArrayList of class Product
        val productList = addProductsToList()

        // This will pass the ArrayList to our Adapter
        val myAdapter = MyCustomAdapter(productList)

        // Setting the Adapter with the RecyclerView
        recyclerView.adapter = myAdapter
        btn_add.setOnClickListener{
            val intent=Intent(this,addContact::class.java)
            startActivity(intent)
        }
    }
    private fun addProductsToList(): ArrayList<User> {
        val list = ArrayList<User>()
        val db=DataBaseHandler(this);
        val data=db.readData()
        list.addAll(data);
        return list
    }
}