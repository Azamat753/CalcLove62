package com.example.calclove62

import android.content.Context
import android.widget.Toast

class Petya(val context: Context) {

  fun showToast( msg: String) {
    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
  }

}