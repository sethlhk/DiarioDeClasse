package com.example.myapplication.model

import com.example.myapplication.R

class Aluno(
    val nome:String,
    val curso: String
) {
    var faltas:Int = 0
    var nota: Int = 0
    var foto: Int = R.drawable.luluhk
}