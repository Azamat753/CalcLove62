package com.example.calclove62.view

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.calclove62.App
import com.example.calclove62.databinding.ActivityHistoryBinding
import com.example.calclove62.remote.LoveModel

class HistoryActivity : AppCompatActivity() {
  lateinit var binding: ActivityHistoryBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityHistoryBinding.inflate(layoutInflater)
    setContentView(binding.root)
    binding.historyTv.movementMethod = ScrollingMovementMethod()

    var list = App.appDatabase.loveDao().getAll()
    var result = ""
    list.forEach {
      result += (it.firstName + "\n" + it.secondName + "\n" + it.percentage + "\n" + it.result + "\n\n")
    }

    binding.historyTv.text = result
    binding.deleteAllBtn.setOnClickListener {
      AlertDialog.Builder(this)
        .setTitle("Delete")
        .setMessage("Are you sure?")
        .setPositiveButton("Yes") { _, _ ->
          App.appDatabase.loveDao().deleteAll()
          updateResult(list, result)
        }.show()
    }

    binding.deleteBtn.setOnClickListener {
      AlertDialog.Builder(this)
        .setTitle("Delete")
        .setMessage("Are you sure?")
        .setPositiveButton("Yes") { _, _ ->
          App.appDatabase.loveDao().deleteByName(binding.nameEd.text.toString())
          updateResult(list, result)
        }.show()
    }
  }

  private fun updateResult(
    list: List<LoveModel>,
    result: String
  ) {
    var list1 = list
    var result1 = result
    list1 = App.appDatabase.loveDao().getAll()
    result1 = ""
    list1.forEach {
      result1 +=
        (it.firstName + "\n" + it.secondName + "\n" + it.percentage + "\n" + it.result + "\n\n")
    }
    binding.historyTv.text = result1
  }
}