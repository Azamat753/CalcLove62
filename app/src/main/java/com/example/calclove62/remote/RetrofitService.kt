package com.example.calclove62.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {
//https://love-calculator.p.rapidapi.com/getPercentage?sname=Alice&fname=John
    var retrofit = Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
    .addConverterFactory(GsonConverterFactory.create()).build()

    var api = retrofit.create(LoveApi::class.java)
}