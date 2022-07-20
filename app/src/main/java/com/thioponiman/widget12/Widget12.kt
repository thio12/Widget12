package com.thioponiman.widget12

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import com.thioponiman.widget12.databinding.ActivityWidget12Binding


//Membuat variabel binding
private lateinit var binding: ActivityWidget12Binding
class Widget12 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //inisialisasi binding
        binding = ActivityWidget12Binding.inflate(layoutInflater)

        //memanggil layout dengan menggunakan binding.root
        setContentView(binding.root)

        //Button Toast
        binding.btnToast.setOnClickListener {
            Toast.makeText(this, "ini adalah Toast", Toast.LENGTH_SHORT).show()
        }

        //Button Snackbar
        binding.btnSnackbar.setOnClickListener {
            Snackbar.make(it, "ini adalah Snackbar", Snackbar.LENGTH_SHORT).show()
        }

        //Button Alert
        binding.btnAlert.setOnClickListener {
            AlertDialog.Builder( this).apply {
                setTitle("Message")
                setMessage("Ini adalah Alert")
                setPositiveButton( "OK"){dialog, _ ->
                    Toast.makeText(applicationContext,"Anda Klik OK", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }

                setNegativeButton( "Back"){ dialog, _ ->
                    Toast.makeText(applicationContext, "Anda Klik Back", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
            }.show()
        }

        binding.btnCustomDialog.setOnClickListener {
            Dialog( this).apply {
                requestWindowFeature(Window.FEATURE_NO_TITLE)
                setCancelable(false)
                setContentView(R.layout.custom_dialog)


                val btnCancel = this.findViewById<Button>(R.id.btnCancel)
                val btnContinue = this.findViewById<Button>(R.id.btnContinue)

                btnCancel.setOnClickListener {
                    Toast.makeText(applicationContext, "Anda klik Cancel", Toast.LENGTH_SHORT).show()
                    this.dismiss()
                }

                btnContinue.setOnClickListener {
                    Toast.makeText(applicationContext, "Anda klik Continue", Toast.LENGTH_SHORT).show()
                    this.dismiss()
                }
            }.show()
        }

    }
}