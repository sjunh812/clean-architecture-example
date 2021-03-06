package org.sjhstudio.cleanarchitectureexample.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sjhstudio.data.api.GithubReposApi
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Singleton
    @Provides
    fun getGithubReposApi(retrofit: Retrofit): GithubReposApi {
        return retrofit.create(GithubReposApi::class.java)
    }

}