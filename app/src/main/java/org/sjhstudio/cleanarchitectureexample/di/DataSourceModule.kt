package org.sjhstudio.cleanarchitectureexample.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sjhstudio.data.repository.remote.GithubRemoteDataSource
import org.sjhstudio.data.repository.remote.GithubRemoteSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Singleton
    @Provides
    fun getGithubRemoteDataSource(sourceImpl: GithubRemoteSourceImpl): GithubRemoteDataSource {
        return sourceImpl
    }

}