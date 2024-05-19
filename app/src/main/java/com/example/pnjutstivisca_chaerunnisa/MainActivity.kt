package com.example.pnjutstivisca_chaerunnisa

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("Hal2", Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()

        // Find views
        emailEditText = findViewById(R.id.email)
        passwordEditText = findViewById(R.id.password)
        loginButton = findViewById(R.id.btnLogin)

        // Load saved data if available
        val savedEmail = sharedPreferences.getString("email_key", "")
        val savedPassword = sharedPreferences.getString("password_key", "")
        emailEditText.setText(savedEmail)
        passwordEditText.setText(savedPassword)

        // Save data on button click and navigate to another activity
        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            editor.putString("email_key", email)
            editor.putString("password_key", password)
            editor.putString("email", "@Visca")
            editor.putString("nim", "2207411007")
            editor.putString("nama", "Visca Chaerunnisa")
            editor.putString("kelas", "TI 4A")
            editor.apply()

            // Create an intent to start a new activity
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }
    }
}
