package com.example.calclove62.remote

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "love-table")
data class LoveModel(
  @SerializedName("fname")
  var firstName: String,
  @SerializedName("sname")
  var secondName: String,
  var percentage: String,
  var result: String,
  @PrimaryKey(autoGenerate = true)
  var id: Int = 0
)

//{
//    "fname": "John",
//    "sname": "Alice",
//    "percentage": "46",
//    "result": "Can choose someone better."
//}