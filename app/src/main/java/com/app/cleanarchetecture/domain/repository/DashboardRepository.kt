package com.app.cleanarchetecture.domain.repository

import com.app.cleanarchetecture.domain.model.DashBoardResponse

interface DashboardRepository {
    suspend fun getDashboard(token: String): DashBoardResponse
}