package com.example.labo04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    private lateinit var shareButton: Button
    private  var nameText: String? = ""
    private var emailText: String? = ""
    private var cellphoneNumber: Int? = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        if (intent != null){
            intent.extras?.apply {
                nameText = getString(MainActivity.NAME_TEXT)
                emailText= getString(MainActivity.EMAIL_TEXT)
                cellphoneNumber= getInt(MainActivity.CELL_NUMBER)
                findViewById<TextView>(R.id.name_text_view).apply{
                    text = getString(R.string.name_text, nameText)
                }
                findViewById<TextView>(R.id.email_text_view).apply {
                    text = getString(R.string.email_text, emailText)
                }
                findViewById<TextView>(R.id.cellphone_text_view).apply {
                    text= getString(R.string.cellphone_text, cellphoneNumber)
                }
            }
        }
        bind()
        onClickListener()
    }
    private fun bind(){
        shareButton = findViewById(R.id.share_button)
    }
    private fun onClickListener(){

        shareButton.setOnClickListener {
            val sendIntent: Intent =Intent().apply{
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Nombre: $nameText" +
                        "\nCorreo: $emailText" +
                        "\nTeléfono: $cellphoneNumber")
                type = "text/plain"
            }
            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }
    }
}