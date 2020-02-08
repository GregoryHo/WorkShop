package com.ns.greg.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.ns.greg.demo.databinding.ActivityCalculatorLinearBinding

/**
 * @author gregho
 * @since 2020-02-08
 */
class MainActivity : AppCompatActivity() {

  private val viewModel = MainActivityViewModel()
  private lateinit var activityCalculatorLinearBinding: ActivityCalculatorLinearBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    /* set content view */
    activityCalculatorLinearBinding =
      DataBindingUtil.setContentView(this, R.layout.activity_calculator_linear)
    activityCalculatorLinearBinding.viewModel = viewModel
  }
}