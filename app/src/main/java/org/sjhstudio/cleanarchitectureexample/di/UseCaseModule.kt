package org.sjhstudio.cleanarchitectureexample.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import org.sjhstudio.domain.repository.GithubRepository
import org.sjhstudio.domain.usecase.GetGithubReposUseCase

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @ViewModelScoped
    @Provides
    fun getGithubReposUseCase(githubRepository: GithubRepository): GetGithubReposUseCase {
        return GetGithubReposUseCase(githubRepository)
    }

}