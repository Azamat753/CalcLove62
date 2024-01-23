package com.example.calclove62

import com.google.gson.annotations.SerializedName

data class LoveModel(
    @SerializedName("fname")
    var firstName: String,
    @SerializedName("sname")
    var secondName: String,
    var percentage: String,
    var result: String,
)

//{
//    "fname": "John",
//    "sname": "Alice",
//    "percentage": "46",
//    "result": "Can choose someone better."
//}