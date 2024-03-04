package com.app.cleanarchetecture.data.repository

import com.app.cleanarchetecture.data.remote.api.ApiService
import com.app.cleanarchetecture.domain.model.DashBoardResponse
import com.app.cleanarchetecture.presentation.utill.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DashboardRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getDashboard():Flow<Resource<DashBoardResponse>> = flow {
        emit(Resource.loading())
        emit(Resource.success(apiService.getDashboard()))
    }.catch {
        emit(Resource.failed(it.message.toString()))
    }
}