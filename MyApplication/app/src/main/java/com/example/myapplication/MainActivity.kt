package com.example.myapplication

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.myapplication.databinding.ActivityMainBinding

import android.view.View

import android.widget.Button

import android.widget.EditText
import android.widget.Toast
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var inputUsername: EditText = findViewById(R.id.input_un)

    var btnLogin: Button = findViewById(R.id.btn_login)

    btnLogin.setOnClickListener(View.OnClickListener {

    var username = inputUsername.text.toString().trim()

   // var password= inputPassword.text.toString()

    Toast.makeText( this, username + "\n previous is my name \n" , Toast.LENGTH_SHORT).show()

        })
    }


}