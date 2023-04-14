package com.example.labo04.ViewModel.MainViewModel

import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private lateinit var nameText: String
    private lateinit var emailText: String
    private var cellphoneNumber = 0

    fun setData(mainName: String, mainEmail: String, mainNumber: Int){
        nameText = mainName
        emailText = mainEmail
        cellphoneNumber = mainNumber
    }

    fun getName() = nameText
    fun getEmail() = emailText
    fun getNumber() = cellphoneNumber
}