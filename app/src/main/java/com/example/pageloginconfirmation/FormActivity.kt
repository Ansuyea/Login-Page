package com.example.pageloginconfirmation

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent

class FormActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        val mainLayout = findViewById<LinearLayout>(R.id.mainLayout)
        mainLayout.setBackgroundResource(R.drawable.bg_bear)

        val name = findViewById<EditText>(R.id.name)
        val email = findViewById<EditText>(R.id.email2)
        val password = findViewById<EditText>(R.id.password2)
        val confirm = findViewById<EditText>(R.id.confirm)

        val genderGroup = findViewById<RadioGroup>(R.id.genderGroup)
        val jurusan = findViewById<Spinner>(R.id.jurusan)

        val cbNyemil = findViewById<CheckBox>(R.id.cbNyemil)
        val cbTidur = findViewById<CheckBox>(R.id.cbTidur)
        val cbNgoding = findViewById<CheckBox>(R.id.cbNgoding)
        val cbBacaBuku = findViewById<CheckBox>(R.id.cbBacaBuku)
        val cbAdalahPokoknya = findViewById<CheckBox>(R.id.cbAdalahPokoknya)
        val cbBacaJurnal = findViewById<CheckBox>(R.id.cbBacaJurnal)
        val cbMainGame = findViewById<CheckBox>(R.id.cbMainGame)
        val btn = findViewById<Button>(R.id.btnSubmit)

        // Spinner Jurusan
        val listJurusan = arrayOf(
            "Pilih Jurusan",
            "DKV",
            "Teknik Industri",
            "Teknik Informatika",
            "Bisnis Digital",
            "Manajemen Retail"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listJurusan)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        jurusan.adapter = adapter

        btn.setOnClickListener {

            val intent = Intent(this, FormActivity::class.java)
            startActivity(intent)

            if (name.text.isEmpty()) {
                toast("Nama tidak boleh kosong")
                return@setOnClickListener
            }

            if (password.text.toString() != confirm.text.toString()) {
                toast("Password tidak sama")
                return@setOnClickListener
            }

            if (genderGroup.checkedRadioButtonId == -1) {
                toast("Pilih gender")
                return@setOnClickListener
            }

            if (jurusan.selectedItem.toString() == "Pilih Jurusan") {
                toast("Pilih jurusan")
                return@setOnClickListener
            }

            val selectedGenderId = genderGroup.checkedRadioButtonId
            val selectedGender = findViewById<RadioButton>(selectedGenderId).text

            val hobiList = mutableListOf<String>()

            if (cbNyemil.isChecked) hobiList.add("Nyemil")
            if (cbTidur.isChecked) hobiList.add("Tidur")
            if (cbNgoding.isChecked) hobiList.add("Ngoding")
            if (cbBacaBuku.isChecked) hobiList.add("Baca Buku")
            if (cbAdalahPokoknya.isChecked) hobiList.add("Adalah Pokoknya")
            if (cbBacaJurnal.isChecked) hobiList.add("Baca Jurnal")
            if (cbMainGame.isChecked) hobiList.add("Main Game")

            AlertDialog.Builder(this)
                .setTitle("Data Anda")
                .setMessage(
                    "Nama: ${name.text}\n" +
                            "Email: ${email.text}\n" +
                            "Gender: $selectedGender\n" +
                            "Jurusan: ${jurusan.selectedItem}\n" +
                            "Hobi: ${hobiList.joinToString()}"
                )
                .setPositiveButton("OK") { _, _ ->
                    toast("Berhasil")
                }
                .show()
        }
    }

    fun toast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}