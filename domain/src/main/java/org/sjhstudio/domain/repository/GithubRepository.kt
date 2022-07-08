package org.sjhstudio.domain.repository

import org.sjhstudio.domain.model.GithubRepo

interface GithubRepository {

    suspend fun getRepos(owner: String): List<GithubRepo>

}