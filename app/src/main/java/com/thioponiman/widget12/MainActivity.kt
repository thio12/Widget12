package com.thioponiman.widget12

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thioponiman.widget12.databinding.ActivityMainBinding


//Membuat variabel binding
private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //inisialisasi binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        //memanggil layout dengan menggunakan binding.root
        setContentView(binding.root)

        val getData = intent.getParcelableExtra<ModelLogin>( "data")
        binding.txtUserName.text = getData?.username.toString()
        binding.txtPassword.text = getData?.password.toString()

        //Explicit Intent
        binding.btnIntentWidget.setOnClickListener {
            val intent = Intent(this, Widget12::class.java)
            startActivity(intent)
        }

        binding.btnIntentExplicit.setOnClickListener {

            val intent = Intent(this, Implicitintent::class.java)
            startActivity(intent)
        }
    }
}