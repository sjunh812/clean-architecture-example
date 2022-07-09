package org.sjhstudio.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import org.sjhstudio.domain.model.GithubRepo
import org.sjhstudio.domain.usecase.GetGithubReposUseCase
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getGithubReposUseCase: GetGithubReposUseCase
): ViewModel() {

    private val _githubRepos = MutableLiveData<List<GithubRepo>>()
    val githubRepos: LiveData<List<GithubRepo>>
        get() = _githubRepos

    fun getGithubRepos(owner: String) {
        getGithubReposUseCase(owner, viewModelScope) {
            _githubRepos.value = it
        }
    }

}