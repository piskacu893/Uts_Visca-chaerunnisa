package com.example.pnjutstivisca_chaerunnisa

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Awal : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var fab: FloatingActionButton
    private var list = mutableListOf<User>()
    private lateinit var adapter: UserAdapter
    private lateinit var database: AppDatabase

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tampilanda)

        // Initialize views
        recyclerView = findViewById(R.id.recycler_View)
        fab = findViewById(R.id.fab)

        // Set up RecyclerView
        adapter = UserAdapter(list)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))

        adapter.setDialog(object : UserAdapter.Dialog {
            override fun onclick(position: Int) {
                val dialog = AlertDialog.Builder(this@tampilanda)
                dialog.setTitle(list[position].Nama_Alumni)
                dialog.setItems(R.array.items_option, DialogInterface.OnClickListener { dialog, which ->
                    if (which == 0) {
                        // Ubah
                        val intent = Intent(this@tampilanda, EditorActivity::class.java)
                        intent.putExtra("nim", list[position].nim)
                        startActivity(intent)
                    } else if (which == 1) {
                        // Hapus
                        database.userDao().delete(list[position])
                        getData()
                    } else {
                        dialog.dismiss()
                    }
                })
                val dialogView = dialog.create()
                dialogView.show()
            }
        })

        // Set up Floating Action Button
        fab.setOnClickListener {
            startActivity(Intent(this, EditorActivity::class.java))
        }

        // Initialize database
        database = AppDatabase.getInstance(applicationContext)
    }

    override fun onResume() {
        super.onResume()
        getData()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun getData() {
        lifecycleScope.launch {
            try {
                val users = withContext(Dispatchers.IO) {
                    database.userDao().getAll()
                }
                list.clear()
                list.addAll(users)
                adapter.notifyDataSetChanged()
                // Handle empty state if necessary
                if (list.isEmpty()) {
                    // Show a message or handle the empty state
                }
            } catch (e: Exception) {
                // Handle any errors
                e.printStackTrace()
            }
        }
    }
}