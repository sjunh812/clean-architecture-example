package org.sjhstudio.cleanarchitectureexample.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sjhstudio.data.repository.remote.GithubRemoteDataSource
import org.sjhstudio.data.repository.remote.GithubRemoteDataSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Singleton
    @Binds
    abstract fun bindsGithubRemoteDataSource(sourceImpl: GithubRemoteDataSourceImpl): GithubRemoteDataSource

}