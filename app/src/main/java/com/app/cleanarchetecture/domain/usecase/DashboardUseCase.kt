package com.app.cleanarchetecture.domain.usecase

import com.app.cleanarchetecture.domain.repository.DashboardRepository
import com.app.cleanarchetecture.domain.model.DashBoardResponse
import com.app.cleanarchetecture.utill.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DashboardUseCase @Inject constructor(private val dashboardRepository: DashboardRepository) {

    operator fun invoke(token: String): Flow<Resource<DashBoardResponse>> = flow {
        emit(Resource.loading())
        emit(Resource.success(dashboardRepository.getDashboard(token)))
    }.catch {
        emit(Resource.failed(it.message.toString()))
    }
}
