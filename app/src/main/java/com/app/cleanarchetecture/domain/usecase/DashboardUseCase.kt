package com.app.cleanarchetecture.domain.usecase

import com.app.cleanarchetecture.data.repository.DashboardRepository
import com.app.cleanarchetecture.domain.model.DashBoardResponse
import com.app.cleanarchetecture.presentation.utill.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DashboardUseCase @Inject constructor(private val repository: DashboardRepository) {

    suspend fun invoke():Flow<Resource<DashBoardResponse>>{
        return repository.getDashboard()
    }
}