package com.exemple.kotlin_apiviacep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonBuscarCep.setOnClickListener {
            /* Realizar a chamada da API passando o caminho do EditText */
            val call = InicializaRetrofit().apiRetrofitServiceJSON().getEnderecoByJSON(editCep.text.toString())

            /* A chamada deve implementar dois metodos: onResponse e onFailure */
            call.enqueue(object : Callback<CEP> {

                /* Caso a resposta seja positiva extraimos o objeto da resposta e exibimos o resultado na tela */
                override fun onResponse(call: Call<CEP>, response: Response<CEP>) {

                    response.let {
                        val CEPs: CEP? = it.body()

                        if (CEPs == null) {
                            textResultado.text = "Cep inválido!"

                        } else {
                            textResultado.text =
                                        "Cep: " + CEPs.cep + "\n" +
                                        "Logradouro: " + CEPs.logradouro + "\n" +
                                        "Bairro: " + CEPs.bairro + "\n" +
                                        "Cidade: " + CEPs.localidade + "\n" +
                                        "UF: " + CEPs.uf
                        }
                    }
                }

                /* Caso ocorra uma falha na resposta lançamos um erro no log */
                override fun onFailure(call: Call<CEP>?, t: Throwable?) {
                    Log.e("Erro", t?.message)
                }
            })
        }
    }
}