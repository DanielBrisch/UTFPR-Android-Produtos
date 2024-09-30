package br.edu.utfpr.trocadetelas

import android.app.Instrumentation.ActivityResult
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts

class LancamentoActivity : AppCompatActivity() {

    private lateinit var etCodigo : EditText
    private lateinit var etQuantidade : EditText
    private lateinit var etValor : EditText

    private lateinit var btnConfirmar : Button
    private lateinit var btnListar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lancamento)

        inciaComponentes()

        btnConfirmar.setOnClickListener {
            confirmar()
        }

        btnListar.setOnClickListener {
            listar()
        }
    }

    private fun confirmar() {
        val intent = Intent(this, ConfirmarActivity::class.java)
        intent.putExtra("codigo", etCodigo.text.toString())
        intent.putExtra("quantidade", etQuantidade.text.toString())
        intent.putExtra("valor", etValor.text.toString())
        startActivity(intent)
    }

    private fun listar() {
        var intent = Intent(this, ListarActivity::class.java)
        getResult.launch(intent)
    }

    private val getResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == RESULT_OK) {
            if (it.data != null) {
                val retorno = it.data?.getStringExtra("codigo")
                etCodigo.setText(retorno)
            }
        }
    }

    private fun inciaComponentes() {
        etCodigo = findViewById(R.id.etCodigo)
        etQuantidade = findViewById(R.id.etQuantidade)
        etValor = findViewById(R.id.etValor)
        btnConfirmar = findViewById(R.id.btnConfirmar)
        btnListar = findViewById(R.id.btnListar)
    }
}