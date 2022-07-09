package org.sjhstudio.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sjhstudio.domain.model.GithubRepo
import org.sjhstudio.presentation.databinding.ItemGithubRepoBinding

class GithubAdapter: RecyclerView.Adapter<GithubAdapter.GithubViewHolder>() {

    private val items = mutableListOf<GithubRepo>()

    inner class GithubViewHolder(
        private val binding: ItemGithubRepoBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(repo: GithubRepo) {
            binding.repo = repo
        }

    }

    fun setItems(items: List<GithubRepo>) {
        this.items.clear()
        this.items.addAll(items)

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return GithubViewHolder(ItemGithubRepoBinding.inflate(layoutInflater))
    }

    override fun onBindViewHolder(holder: GithubViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

}