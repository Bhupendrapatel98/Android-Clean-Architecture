package com.app.cleanarchetecture.data.repository

import com.app.cleanarchetecture.data.remote.api.ApiService
import com.app.cleanarchetecture.domain.model.DashBoardResponse
import com.app.cleanarchetecture.domain.repository.DashboardRepository
import javax.inject.Inject


class DashboardRepositoryImpl @Inject constructor(private val apiService: ApiService): DashboardRepository {
    override suspend fun getDashboard(token: String): DashBoardResponse {
       return apiService.getDashboard(token)
    }

}