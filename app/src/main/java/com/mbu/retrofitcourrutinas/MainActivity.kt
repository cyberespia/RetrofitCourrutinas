package com.mbu.retrofitcourrutinas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private val BASE_URL = "https://dark-api.herokuapp.com/api/"
    private val TAG_LOGS = "Mariox"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //creamos una instancia de la clase retorfit
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        //creamos servicio para hacer la llamada
        val servicio = retrofit.create(APIService::class.java)

        //comenzamos a usar el servicio
/*        servicio.getFrases().enqueue(object: Callback<List<Frases>>{
            override fun onResponse(call: Call<List<Frases>>, response: Response<List<Frases>>) {

                val frases = response.body()
                Log.i(TAG_LOGS, Gson().toJson(frases))
            }

            override fun onFailure(call: Call<List<Frases>>, t: Throwable) {
                t.printStackTrace()
            }

        })*/

        //usamos el srvicio con corrutinas

        CoroutineScope(Dispatchers.IO).launch {
            val response = servicio.getFrases()

            if (response.isSuccessful) {
                val frases = response.body()
                Log.i(TAG_LOGS, Gson().toJson(frases))
            }


        }


    }
}