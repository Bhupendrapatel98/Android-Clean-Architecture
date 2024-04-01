package com.app.cleanarchetecture.di

import com.app.cleanarchetecture.data.remote.api.ApiService
import com.app.cleanarchetecture.data.repository.DashboardRepositoryImpl
import com.app.cleanarchetecture.domain.repository.DashboardRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    //will make variant
    @Provides
    fun provideBaseUrl(): String = "https://api.finitt.io/"

    @Provides
    @Singleton
    fun provideRetrofitBuilder(baseUrl: String): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideDashboardRepository(apiService: ApiService):DashboardRepository = DashboardRepositoryImpl(apiService)
}