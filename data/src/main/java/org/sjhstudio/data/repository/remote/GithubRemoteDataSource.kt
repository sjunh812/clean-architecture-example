package org.sjhstudio.data.repository.remote

import org.sjhstudio.data.api.GithubReposApi
import org.sjhstudio.data.model.GithubRepoResponse
import javax.inject.Inject

interface GithubRemoteDataSource {
    suspend fun getRepo(owner: String): List<GithubRepoResponse>
}

class GithubRemoteSourceImpl @Inject constructor(
    private val githubReposApi: GithubReposApi
): GithubRemoteDataSource {

    override suspend fun getRepo(owner: String): List<GithubRepoResponse> {
        return githubReposApi.getRepos(owner)
    }

}