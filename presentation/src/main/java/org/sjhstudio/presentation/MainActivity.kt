package org.sjhstudio.presentation

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
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
            rv.apply {
                adapter = GithubAdapter()
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
            submitBtn.setOnClickListener {
                val owner = ownerEt.text.toString()
                viewModel.apply {
                    getGithubRepos(owner)
                    handleLoading(true)
                }
            }
        }
    }

    private fun setProg(visible: Boolean) {
        with(binding.prog) {
            visibility = if(visible) View.VISIBLE else View.GONE
        }
    }

    private fun setUpGithubRepos() {
        with(viewModel) {
            githubRepos.observe(this@MainActivity) {
                (binding.rv.adapter as GithubAdapter).setItems(it)
            }
            loading.observe(this@MainActivity) {
                if(it) setProg(true)
                else setProg(false)
            }
        }
    }

}