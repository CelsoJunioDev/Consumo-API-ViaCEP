package com.exemple.kotlin_apiviacep

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

class InicializaRetrofit {

    /* Consumir JSON da API e converter (parser) */
    val retrofitJSON = Retrofit.Builder()
        .baseUrl("https://viacep.com.br/ws/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // Implementar a interface
    fun apiRetrofitServiceJSON(): RetrofitService {
        return retrofitJSON.create(RetrofitService::class.java)
    }

}