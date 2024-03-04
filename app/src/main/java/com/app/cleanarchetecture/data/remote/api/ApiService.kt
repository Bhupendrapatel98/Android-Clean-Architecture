package com.app.cleanarchetecture.data.remote.api

import com.app.cleanarchetecture.domain.model.DashBoardResponse
import retrofit2.http.GET

interface ApiService {
    @GET("user/dashboard")
    suspend fun getDashboard(): DashBoardResponse
}