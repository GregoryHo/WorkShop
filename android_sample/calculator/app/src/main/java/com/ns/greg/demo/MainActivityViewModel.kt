package com.ns.greg.demo

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author gregho
 * @since 2020-02-08
 */
class MainActivityViewModel : ViewModel() {

  val calculateModel = CalculateModel()
  val resultLiveData = MutableLiveData<String>()

  fun onClickedButton(view: View) {
    when (view.id) {
      R.id.zero_button -> {
        resultLiveData.value = "0"
      }

      R.id.one_button -> {
        resultLiveData.value = "1"
      }

      R.id.two_button -> {
        resultLiveData.value = "2"
      }

      R.id.three_button -> {
        resultLiveData.value = "3"
      }

      R.id.four_button -> {
        resultLiveData.value = "4"
      }

      R.id.five_button -> {
        resultLiveData.value = "5"
      }

      R.id.six_button -> {
        resultLiveData.value = "6"
      }

      R.id.seven_button -> {
        resultLiveData.value = "7"
      }

      R.id.eight_button -> {
        resultLiveData.value = "8"
      }

      R.id.nine_button -> {
        resultLiveData.value = "9"
      }
    }
  }
}