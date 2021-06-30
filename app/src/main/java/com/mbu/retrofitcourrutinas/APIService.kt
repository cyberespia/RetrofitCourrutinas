package com.mbu.retrofitcourrutinas

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface APIService {
    //llamada get , no se pone la URL completa (https://dark-api.herokuapp.com/api/v1/quote) ,
    // la URL base o comum (https://dark-api.herokuapp.com/api/) se pondra luego
    @GET("v1/quote")
    //Metodo que devuelve los objetos o listas
    suspend fun getFrases(): Response<List<Frases>>

}
