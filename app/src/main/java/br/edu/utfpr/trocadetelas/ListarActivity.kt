package br.edu.utfpr.trocadetelas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class ListarActivity : AppCompatActivity() {

    private lateinit var lvProdutos : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar)

        lvProdutos = findViewById(R.id.lvProdutos)

        lvProdutos.setOnItemClickListener { parent, view, position, id ->
            val codigoSelecionado = position + 1
            intent.putExtra("codigo", codigoSelecionado)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}