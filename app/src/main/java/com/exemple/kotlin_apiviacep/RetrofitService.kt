package com.exemple.kotlin_apiviacep

import android.telecom.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {

    /* Mapeando os caminhos (path) */

    @GET("{CEP}/json/")
    fun getEnderecoByJSON(@Path("CEP") CEP : String) : retrofit2.Call<CEP>


}