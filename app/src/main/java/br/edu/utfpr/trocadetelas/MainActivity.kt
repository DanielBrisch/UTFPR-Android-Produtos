package br.edu.utfpr.trocadetelas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var btnLancamento : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLancamento = findViewById(R.id.btnLancamento)

        btnLancamento.setOnClickListener {
            clickLancamento()
        }
    }

    private fun clickLancamento() {
        val intent = Intent(this, LancamentoActivity::class.java)
        startActivity(intent)
    }
}