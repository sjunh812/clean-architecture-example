package org.sjhstudio.data.mapper

import org.sjhstudio.data.model.GithubRepoResponse
import org.sjhstudio.domain.model.GithubRepo

fun mapperToGithubRepos(repos: List<GithubRepoResponse>): List<GithubRepo> {
    return repos.map { res ->
        GithubRepo(
            name = res.name,
            url = res.url
        )
    }
}