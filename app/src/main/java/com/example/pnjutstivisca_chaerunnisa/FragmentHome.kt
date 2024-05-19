package com.example.pnjutstivisca_chaerunnisa

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_home)

        // Set edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbar = findViewById<Toolbar>(R.id.option_menu)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    // Fungsi yang dipanggil saat tombol "Profile" ditekan
    fun navigateToProfile(view: View) {
        val intent = Intent(this, Profile::class.java)
        startActivity(intent)
    }

    // Fungsi yang dipanggil saat tombol "Berita" ditekan
    fun navigateToBerita(view: View) {
        val intent = Intent(this, FragmentBerita::class.java)
        startActivity(intent)
    }
}
