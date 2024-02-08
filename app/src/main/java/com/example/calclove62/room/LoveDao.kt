package com.example.calclove62.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.calclove62.remote.LoveModel

@Dao
interface LoveDao {

  @Insert
  fun insertLove(love: LoveModel)

  @Query("SELECT * FROM `love-table`")
  fun getAll(): List<LoveModel>

  @Query("DELETE FROM `love-table` WHERE firstName = :name OR secondName = :name OR percentage =:name")
  fun deleteByName(name: String)

  @Query("DELETE FROM `love-table`")
  fun deleteAll()

}