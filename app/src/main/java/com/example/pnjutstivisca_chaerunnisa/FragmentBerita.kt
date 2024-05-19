package com.example.pnjutstivisca_chaerunnisa

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FragmentBerita : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_berita)

        // Set edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    fun navigateToProfile(view: View) {
        val intent = Intent(this, Profile::class.java)
        startActivity(intent)
    }


    fun navigateToHome(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
