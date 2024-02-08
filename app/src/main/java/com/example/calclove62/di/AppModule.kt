package com.example.calclove62.di

import android.content.Context
import android.content.SharedPreferences
import com.example.calclove62.Aibek
import com.example.calclove62.Petya
import com.example.calclove62.Svetlana
import com.example.calclove62.Vasya
import com.example.calclove62.remote.LoveApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

  @Provides
  fun provideApi(): LoveApi {
    return Retrofit.Builder()
      .baseUrl("https://love-calculator.p.rapidapi.com/")
      .addConverterFactory(GsonConverterFactory.create())
      .build().create(LoveApi::class.java)
  }

  @Provides
  fun providePetya(@ApplicationContext context: Context): Petya {
    return Petya(context)
  }

  @Provides
  fun provideVasya(): Vasya {
    return Vasya()
  }

  @Provides
  fun provideSveta(): Svetlana {
    return Svetlana()
  }

  @Provides
  fun provideAibek(): Aibek {
    return Aibek(nameA = "Aibek A", shirtA = "Jacket", weaponA = "Glock")
  }

//  @Provides
//  fun providePreferences():SharedPreferences{
//    return
//  }

}