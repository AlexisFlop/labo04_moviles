package com.example.labo04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import com.example.labo04.ViewModel.MainViewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var saveButton: Button
    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var cellphoneNumberEditText: EditText


    private val mainVIewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        onClickListener()
    }

    private fun bind() {
        saveButton = findViewById(R.id.save_button)
        nameEditText = findViewById(R.id.name_edit_text)
        emailEditText = findViewById(R.id.email_input_text)
        cellphoneNumberEditText = findViewById(R.id.cellphone_number_input_text)
    }
    private fun onClickListener(){
        saveButton.setOnClickListener{
            mainVIewModel.setData(nameEditText.text.toString(), emailEditText.text.toString(), cellphoneNumberEditText.text.toString().toInt())
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra(NAME_TEXT, mainVIewModel.getName())
            intent.putExtra(EMAIL_TEXT, mainVIewModel.getEmail())
            intent.putExtra(CELL_NUMBER, mainVIewModel.getNumber())
            startActivity(intent)
        }
    }

    companion object{
        const val NAME_TEXT = "NAME_TEXT"
        const val EMAIL_TEXT = "EMAIL_TEXT"
        const val CELL_NUMBER = "CELL_NUMBER"
    }
}