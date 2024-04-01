package com.app.cleanarchetecture.data.remote.api

import com.app.cleanarchetecture.domain.model.DashBoardResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {
    @GET("loanpoint/dashboard")
    suspend fun getDashboard(@Header("Authorization") accessToken: String): DashBoardResponse

}