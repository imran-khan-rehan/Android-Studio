package com.example.myfirstapp

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import  android.widget.Toast
import android.content.Intent
import android.widget.TextView

import  androidx.activity.ComponentActivity
class MainActivity:ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list_view:ListView=findViewById(R.id.list_view)
        val l:TextView=findViewById(R.id.list2)
        l.setText("fkfhdk")
      val myadapter:ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_list_item_1,Utilis.languagesArray)
      list_view.adapter=myadapter
       list_view.onItemClickListener=AdapterView.OnItemClickListener{adapterView,view,position, id ->
           val selectedItem=adapterView.getItemAtPosition(position) as String

            val url:String=Utilis.urlArray[position]
            Toast.makeText(applicationContext, selectedItem,Toast.LENGTH_SHORT).show()

            val intent: Intent = Intent(  this,WebActivity::class.java)

            intent.putExtra( "URL", url)

            startActivity(intent)
       }
    }
}