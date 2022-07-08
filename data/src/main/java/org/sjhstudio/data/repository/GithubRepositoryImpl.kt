package org.sjhstudio.data.repository

import org.sjhstudio.domain.model.GithubRepo
import org.sjhstudio.domain.repository.GithubRepository

class GithubRepositoryImpl: GithubRepository {

    override suspend fun getRepos(owner: String): List<GithubRepo> {
        TODO("Not yet implemented")
    }

}