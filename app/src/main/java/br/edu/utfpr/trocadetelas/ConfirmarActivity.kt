package br.edu.utfpr.trocadetelas

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ConfirmarActivity : AppCompatActivity() {

    private lateinit var tvCodigo : TextView
    private lateinit var tvQuantidade : TextView
    private lateinit var tvValor : TextView

    private lateinit var btnConfirmar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmar)

        iniciaComponentes()
        inciaValores()

        btnConfirmar.setOnClickListener {
            confirmar()
        }
    }

    private fun confirmar() {
        val smsBody = "Cod: ${tvCodigo.text}, quantidade: ${tvQuantidade.text}, valor: ${tvValor.text}"
        val phone_number = "sms:+5546999347534"

        val intent = Intent( Intent.ACTION_VIEW)
        intent.setData( Uri.parse(phone_number))
        intent.putExtra("sms_body", smsBody)

        startActivity(intent)
    }

    private fun inciaValores() {
        val codigo = intent.getStringExtra("codigo")
        val quantidade = intent.getStringExtra("quantidade")
        val valor = intent.getStringExtra("valor")

        tvCodigo.setText(codigo)
        tvQuantidade.setText(quantidade)
        tvValor.setText(valor)
    }

    private fun iniciaComponentes() {
        tvCodigo = findViewById(R.id.tvCodigo)
        tvQuantidade = findViewById(R.id.tvQuantidade)
        tvValor = findViewById(R.id.tvValor)
        btnConfirmar = findViewById(R.id.btnConfirmar)
    }
}