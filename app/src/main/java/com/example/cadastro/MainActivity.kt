package com.example.cadastro

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var nomeCompleto: EditText
    private lateinit var telefone: EditText
    private lateinit var email: EditText
    private lateinit var ingressarEmail: CheckBox
    private lateinit var sexoGroup: RadioGroup
    private lateinit var cidade: EditText
    private lateinit var ufSpinner: Spinner
    private lateinit var btnLimpar: Button
    private lateinit var btnSalvar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        nomeCompleto = findViewById(R.id.nomeCompleto)
        telefone = findViewById(R.id.telefone)
        email = findViewById(R.id.email)
        ingressarEmail = findViewById(R.id.ingressarEmail)
        sexoGroup = findViewById(R.id.sexoGroup)
        cidade = findViewById(R.id.cidade)
        ufSpinner = findViewById(R.id.ufSpinner)
        btnLimpar = findViewById(R.id.btnLimpar)
        btnSalvar = findViewById(R.id.btnSalvar)


        val ufs = resources.getStringArray(R.array.ufs)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, ufs)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        ufSpinner.adapter = adapter


        btnSalvar.setOnClickListener {
            val nome = nomeCompleto.text.toString()
            val tel = telefone.text.toString()
            val emailText = email.text.toString()
            val ingressar = ingressarEmail.isChecked
            val sexoId = sexoGroup.checkedRadioButtonId
            val sexo = if (sexoId == R.id.sexoMasculino) "Masculino" else "Feminino"
            val cidadeText = cidade.text.toString()
            val uf = ufSpinner.selectedItem.toString()

            val formulario = Formulario(nome, tel, emailText, ingressar, sexo, cidadeText, uf)
            Toast.makeText(this, formulario.toString(), Toast.LENGTH_LONG).show()
        }


        btnLimpar.setOnClickListener {
            nomeCompleto.text.clear()
            telefone.text.clear()
            email.text.clear()
            ingressarEmail.isChecked = false
            sexoGroup.clearCheck()
            cidade.text.clear()
            ufSpinner.setSelection(0)
        }
    }
}

data class Formulario(
    val nome: String,
    val telefone: String,
    val email: String,
    val ingressarEmail: Boolean,
    val sexo: String,
    val cidade: String,
    val uf: String
)
