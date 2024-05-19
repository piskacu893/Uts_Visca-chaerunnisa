package com.example.pnjutstivisca_chaerunnisa

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val sharedPreferences = getSharedPreferences("Hal2", MODE_PRIVATE)
        val email = sharedPreferences.getString("email", "")
        val nama = sharedPreferences.getString("nama", "")
        val nim = sharedPreferences.getString("nim", "")
        val kelas = sharedPreferences.getString("kelas", "")

        val emailEditText = findViewById<EditText>(R.id.editTextEmail)
        val namaEditText = findViewById<EditText>(R.id.editTextNama)
        val nimEditText = findViewById<EditText>(R.id.editTextNIM)
        val kelasEditText = findViewById<EditText>(R.id.editTextKelas)

        emailEditText.setText(email)
        namaEditText.setText(nama)
        nimEditText.setText(nim)
        kelasEditText.setText(kelas)
    }

    fun navigateToHome(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun navigateToBerita(view: View) {
        val intent = Intent(this, FragmentBerita::class.java)
        startActivity(intent)
    }

    fun logout(view: View) {
        // Clear shared preferences
        val sharedPreferences = getSharedPreferences("Hal2", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()

        // Navigate back to MainActivity
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish() // Optional: Close the current activity
    }
}
