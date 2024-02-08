package com.example.calclove62.view

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.calclove62.Aibek
import com.example.calclove62.App
import com.example.calclove62.LoveViewModel
import com.example.calclove62.Petya
import com.example.calclove62.Repository
import com.example.calclove62.Svetlana
import com.example.calclove62.Vasya
import com.example.calclove62.remote.RetrofitService
import com.example.calclove62.databinding.ActivityMainBinding
import com.example.calclove62.remote.LoveModel
import dagger.Provides
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMainBinding
  private val viewModel: LoveViewModel by viewModels()

  @Inject
  lateinit var repository: Repository

  @Inject
  lateinit var petya: Petya

  @Inject
  lateinit var vasya: Vasya

  @Inject
  lateinit var svetlana: Svetlana

  @Inject
  lateinit var aibek: Aibek


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)
    initClickers()
    //hello world master
  }

  @SuppressLint("SetTextI18n")
  private fun initClickers() {
    with(binding) {
      historyBtn.setOnClickListener {
        startActivity(Intent(this@MainActivity, HistoryActivity::class.java))
      }
      calculateBtn.setOnClickListener {

        viewModel.getLove(
          firstName = binding.firstEd.text.toString(),
          secondName = binding.secondEd.text.toString()
        ).observe(this@MainActivity, Observer {
          it?.let { model ->
            App.appDatabase.loveDao().insertLove(model)
            resultTv.text =
              "${model.firstName} \n ${model.secondName}\n ${model.percentage}\n ${model.result}"
          }
        })
      }
    }
  }
}