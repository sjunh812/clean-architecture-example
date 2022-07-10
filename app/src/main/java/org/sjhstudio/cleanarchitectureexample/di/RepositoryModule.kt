package org.sjhstudio.cleanarchitectureexample.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sjhstudio.data.repository.GithubRepositoryImpl
import org.sjhstudio.domain.repository.GithubRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindsGithubRepository(githubRepository: GithubRepositoryImpl): GithubRepository

}