package com.example.pageloginconfirmation

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password)
        val btn = findViewById<Button>(R.id.btnNext)

        btn.setOnClickListener {

            if (email.text.toString().isEmpty()) {
                Toast.makeText(this, "Email kosong", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()) {
                Toast.makeText(this, "Email tidak valid", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password.text.toString().isEmpty()) {
                Toast.makeText(this, "Password kosong", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this@MainActivity, FormActivity::class.java)
            intent.putExtra("email", email.text.toString())
            intent.putExtra("password", password.text.toString())

            startActivity(intent)
        }
    }
}