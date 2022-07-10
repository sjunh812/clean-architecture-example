package org.sjhstudio.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sjhstudio.domain.model.GithubRepo
import org.sjhstudio.presentation.databinding.ItemGithubRepoBinding

class GithubAdapter: RecyclerView.Adapter<GithubViewHolder>() {

    private val items = mutableListOf<GithubRepo>()

    fun setItems(items: List<GithubRepo>) {
        this.items.clear()
        this.items.addAll(items)
        println("xxx items size:${items.size}")
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

class GithubViewHolder(
    private val binding: ItemGithubRepoBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(repo: GithubRepo) {
        binding.repo = repo
        println("xxx name:${repo.name}, url:${repo.url}")
    }

}