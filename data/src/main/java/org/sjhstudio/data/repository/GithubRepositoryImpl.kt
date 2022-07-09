package org.sjhstudio.data.repository

import org.sjhstudio.data.mapper.mapperToGithubRepos
import org.sjhstudio.data.repository.remote.GithubRemoteDataSource
import org.sjhstudio.domain.model.GithubRepo
import org.sjhstudio.domain.repository.GithubRepository
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor(
    private val githubRemoteDataSource: GithubRemoteDataSource
): GithubRepository {

    override suspend fun getRepos(owner: String): List<GithubRepo> {
        return mapperToGithubRepos(githubRemoteDataSource.getRepo(owner))
    }

}