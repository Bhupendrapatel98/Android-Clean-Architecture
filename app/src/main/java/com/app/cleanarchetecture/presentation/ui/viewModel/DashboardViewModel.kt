package com.app.cleanarchetecture.presentation.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.cleanarchetecture.domain.model.DashBoardResponse
import com.app.cleanarchetecture.domain.usecase.DashboardUseCase
import com.app.cleanarchetecture.presentation.utill.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(private val getDashboardUseCase: DashboardUseCase) : ViewModel() {

    private var _dashboard = MutableStateFlow<Resource<DashBoardResponse>>(Resource.loading())
    val dashboard: StateFlow<Resource<DashBoardResponse>> = _dashboard

    fun fetchDashBoard(){
        viewModelScope.launch {
            getDashboardUseCase.invoke().collect{
                _dashboard.value = it
            }
        }
    }
}