package org.sjhstudio.presentation

import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import org.sjhstudio.presentation.base.BaseActivity
import org.sjhstudio.presentation.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initUi()
        setUpGithubRepos()
    }

    private fun initUi() {
        with(binding) {
            rv.adapter = GithubAdapter()
            submitBtn.setOnClickListener {
                val owner = ownerEt.text.toString()
                viewModel.getGithubRepos(owner)
            }
        }
    }

    private fun setUpGithubRepos() {
        with(viewModel) {
            githubRepos.observe(this@MainActivity) {
                (binding.rv.adapter as GithubAdapter).setItems(it)
            }
        }
    }

}