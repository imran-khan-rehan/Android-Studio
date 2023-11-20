package com.example.listview
import  android.content.Intent
import android.os.Bundle
import  android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
class LoginActivity:ComponentActivity() {
    companion object{
        var usernameText:String="username"
        var passwordText:String="password"
        var ageText:String="Age"
        var cgpaText:String="CGPA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var inputUsername:EditText=findViewById(R.id.input_username)
        var inputPassword:EditText=findViewById(R.id.input_password)
        var btnLogin:Button=findViewById(R.id.btn_login)
        btnLogin.setOnClickListener(View.OnClickListener {
            var username=inputUsername.text.toString().trim()
            var password=inputPassword.text.toString()
//            Log.d("LoginActivity", "Username: $username, Password: $password")

            var intent=Intent(this,HomeActivity::class.java)
//            intent.putExtra(usernameText,username)
           intent.putExtra(passwordText,password)
            usernameText=username;
            intent.putExtra(ageText,"here is age")
            intent.putExtra(cgpaText,"here is cgpa 1.8")
            startActivity(intent)
        })
    }
}