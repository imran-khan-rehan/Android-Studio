package com.example.listview
import  android.content.Intent
import  android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import org.w3c.dom.Text

class HomeActivity:ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val intent:Intent=intent
        val uname=intent.getStringExtra(LoginActivity.usernameText)
        val pswd=intent.getStringExtra(LoginActivity.passwordText)
        val age=intent.getStringExtra(LoginActivity.ageText)
        val cgpa=intent.getStringExtra(LoginActivity.cgpaText)
val outputText=uname+"\n"+pswd+"\n"+age+"\n"+cgpa
        val outputView:TextView=findViewById<TextView>(R.id.output_tv)
        outputView.setText(outputText)
    }
}