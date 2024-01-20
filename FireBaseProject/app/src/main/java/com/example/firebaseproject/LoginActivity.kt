package com.example.firebaseproject


import android.R.attr
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.google.firebase.auth.FirebaseAuth


class LoginActivity: ComponentActivity() {
    private lateinit var editTextUsername: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var btnSignUp: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup);
        editTextUsername = findViewById(R.id.editTextUsername)
        editTextPassword = findViewById(R.id.editTextPassword)
        btnSignUp = findViewById(R.id.btnSignUp)
        btnSignUp.text="signin";
        btnSignUp.setOnClickListener {
            val email = editTextUsername.text.toString().trim()
            val password = editTextPassword.text.toString().trim()

            // Check if email and password are not empty
            if (email.isNotEmpty() && password.isNotEmpty()) {
                registerUser(email, password)
            } else {
                Toast.makeText(this@LoginActivity, "Please enter both email and password", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun registerUser(email: String, password: String) {

        val mAuth = FirebaseAuth.getInstance()

// Inside your signup button click listener

// Inside your signup button click listener
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(
                this
            ) { task ->
                if (task.isSuccessful) {
                    // Sign up success
                    Toast.makeText(
                        this@LoginActivity, "Authentication success.",
                        Toast.LENGTH_SHORT
                    ).show()
                    var intent=Intent(this,HomeActivity::class.java);
                    startActivity(intent);
                    // You can add additional logic here, like navigating to the main activity
                } else {
                    // If sign up fails, display a message to the user.
                    Toast.makeText(
                        this@LoginActivity, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }
}