package org.sjhstudio.data.api

import org.sjhstudio.data.model.GithubRepoResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubReposApi {

    @GET("/users/{owner}/repos")
    suspend fun getRepos(@Path("owner") owner: String): List<GithubRepoResponse>

}