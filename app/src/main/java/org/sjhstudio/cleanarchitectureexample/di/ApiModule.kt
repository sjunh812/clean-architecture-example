package org.sjhstudio.cleanarchitectureexample.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sjhstudio.data.api.GithubReposApi
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    fun getGithubReposApi(retrofit: Retrofit): GithubReposApi {
        return retrofit.create(GithubReposApi::class.java)
    }

}