package com.example.pnjutstivisca_chaerunnisa

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.pnjutstimuhammad_arifandi1.data.AppDatabase
import com.example.pnjutstimuhammad_arifandi1.data.entity.User

class EditorActivity : AppCompatActivity() {
    private lateinit var nim: EditText
    private lateinit var namaAlumni: EditText
    private lateinit var tempatLahir: EditText
    private lateinit var tanggalLahir: EditText
    private lateinit var alamat: EditText
    private lateinit var agama: EditText
    private lateinit var telephone: EditText
    private lateinit var tahunMasuk: EditText
    private lateinit var tahunLulus: EditText
    private lateinit var pekerjaan: EditText
    private lateinit var jabatan: EditText
    private lateinit var btnSave: Button
    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_editor)

        nim = findViewById(R.id.nim)
        namaAlumni = findViewById(R.id.Nama_Alumni)
        tempatLahir = findViewById(R.id.Tempat_Lahir)
        tanggalLahir = findViewById(R.id.Tanggal_Lahir)
        alamat = findViewById(R.id.Alamat)
        agama = findViewById(R.id.Agama)
        telephone = findViewById(R.id.Telephone)
        tahunMasuk = findViewById(R.id.Tahun_Masuk)
        tahunLulus = findViewById(R.id.Tahun_Lulus)
        pekerjaan = findViewById(R.id.Pekerjaan)
        jabatan = findViewById(R.id.Jabatan)
        btnSave = findViewById(R.id.btn_save)

        database = AppDatabase.getInstance(applicationContext)

        val intent = intent.extras
        if (intent != null) {
            val nimValue = intent.getInt("nim", 0)
            val user = database.userDao().get(nimValue)

            if (user != null) {
                nim.setText(user.nim.toString())
                namaAlumni.setText(user.Nama_Alumni)
                tempatLahir.setText(user.Tempat_Lahir)
                tanggalLahir.setText(user.Tempat_Lahir)
                alamat.setText(user.Alamat)
                agama.setText(user.Agama)
                telephone.setText(user.Telephone)
                tahunMasuk.setText(user.Tahun_Masuk)
                tahunLulus.setText(user.Tahun_Masuk)
                pekerjaan.setText(user.Pekerjaan)
                jabatan.setText(user.Jabatan)
            }
        }

        btnSave.setOnClickListener {
            if (nim.text.isNotEmpty() && namaAlumni.text.isNotEmpty() && tempatLahir.text.isNotEmpty() &&
                tanggalLahir.text.isNotEmpty() && alamat.text.isNotEmpty() && agama.text.isNotEmpty() &&
                telephone.text.isNotEmpty() && tahunMasuk.text.isNotEmpty() && tahunLulus.text.isNotEmpty() &&
                pekerjaan.text.isNotEmpty() && jabatan.text.isNotEmpty()
            ) {
                val user = User(
                    nim.text.toString().toInt(),
                    namaAlumni.text.toString(),
                    tempatLahir.text.toString(),
                    tanggalLahir.text.toString(),
                    alamat.text.toString(),
                    agama.text.toString(),
                    telephone.text.toString(),
                    tahunMasuk.text.toString(),
                    tahunLulus.text.toString(),
                    pekerjaan.text.toString(),
                    jabatan.text.toString()
                )

                if (intent != null && intent.containsKey("nim")) {
                    database.userDao().update(user)
                } else {
                    database.userDao().insertAll(user)
                }

                finish()
            } else {
                Toast.makeText(
                    applicationContext,
                    "data di isis yaaa",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}