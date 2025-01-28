package com.example.appreceitasdevotlrf

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvReceitas : RecyclerView
    private lateinit var receitasAdapter: ReceitasAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        rvReceitas = findViewById(R.id.rv_receitas)

        val lista = listOf(
            Receita("Escondidinho de Camarão", "45 min", R.drawable.carne1,
                listOf("1 KG Camarão", "Manteiga", "Alho", "Cebola")
            ),
            Receita("Panqueca de Carne Moída", "35 min", R.drawable.carne2,
                listOf("1 KG Carne Moida", "Alho", "Cebola")
            ),
            Receita("Rocambole de Carne Moída", "60 min", R.drawable.carne3,
                listOf("Carne a vontade", "Manteiga", "Alho", "Cebola")
            ),
            Receita("Escondidinho de Carne Seca", "55 min", R.drawable.carne4,
                listOf("1 KG Carne Seca", "Alho", "Cebola", "Batatas")
            ),
        )

        // Adapter
        receitasAdapter = ReceitasAdapter{ receita ->
            val intent = Intent(this, DetalhesActivity::class.java)
            intent.putExtra("receita", receita)
            startActivity( intent )
        }
        rvReceitas.adapter = receitasAdapter
        receitasAdapter.configurarLista(lista)

        // Layout
        rvReceitas.layoutManager = LinearLayoutManager(this)
    }
}