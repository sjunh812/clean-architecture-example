package org.sjhstudio.domain.usecase

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import org.sjhstudio.domain.model.GithubRepo
import org.sjhstudio.domain.repository.GithubRepository

/**
 * UseCase 는 Domain 계층으로 안드로이드 의존성을 주입받지 못한다!!
 * 그러므로, app 계층에서 따로 Module 화 해줘야함!!
 */
class GetGithubReposUseCase(private val githubRepository: GithubRepository) {

    operator fun invoke(
        owner: String,
        scope: CoroutineScope,
        onResult: (List<GithubRepo>) -> Unit = {}
    ) {
        scope.launch {
            val deferred = async(IO) {
                githubRepository.getRepos(owner)
            }
            onResult(deferred.await())
        }
    }

}