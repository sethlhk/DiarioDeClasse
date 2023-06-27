package com.example.myapplication.data

import com.example.myapplication.model.Aluno

class ListaDeAlunos {

    fun carregarListaDeAlunos():List<Aluno>{
        return listOf<Aluno>(
            Aluno("Laura", "Kotlin"),
            Aluno("Maria Aghata", "Kotlin"),
            Aluno("Pedro","Kotlin"),
            Aluno("Anne","Kotlin"),
            Aluno("Celine","Kotlin"),
            Aluno("Enzo","Kotlin"),
            Aluno("Mariana", "Kotlin"),
            Aluno("Michelle", "Kotlin")
        )

    }
}