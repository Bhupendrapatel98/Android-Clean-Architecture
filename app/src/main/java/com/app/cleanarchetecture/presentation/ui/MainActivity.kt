package com.app.cleanarchetecture.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.app.cleanarchetecture.R
import com.app.cleanarchetecture.databinding.ActivityMainBinding
import com.app.cleanarchetecture.presentation.ui.viewModel.DashboardViewModel
import com.app.cleanarchetecture.presentation.utill.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private val dashboardViewModel : DashboardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        getDashboardData()
    }

    private fun getDashboardData(){
        dashboardViewModel.fetchDashBoard()

        lifecycleScope.launch {
            dashboardViewModel.dashboard.collect{
                when(it){
                    is Resource.Loading->{
                        Toast.makeText(this@MainActivity, "Loading", Toast.LENGTH_SHORT).show();
                    }
                    is Resource.Success->{
                        Toast.makeText(this@MainActivity, "Success"+it.data, Toast.LENGTH_SHORT).show();
                    }
                    is Resource.Failed->{
                        Toast.makeText(this@MainActivity, "Failed"+it.message, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }
}