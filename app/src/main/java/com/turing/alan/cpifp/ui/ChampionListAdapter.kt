package com.turing.alan.cpifp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.turing.alan.cpifp.data.Champion
import com.turing.alan.cpifp.databinding.ChampionItemBinding

class ChampionListAdapter(): ListAdapter<Champion, ChampionListAdapter.ChampViewHolder>(ChampDiffCallBack) {

    class ChampViewHolder(private val binding: ChampionItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(champ:Champion) {
            binding.championName.text = champ.name
            binding.championTitle.text = champ.title
            binding.championLore.text = champ.lore
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChampViewHolder {
        val binding:ChampionItemBinding = ChampionItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ChampViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChampViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    object ChampDiffCallBack: DiffUtil.ItemCallback<Champion>() {
        override fun areItemsTheSame(oldItem: Champion, newItem: Champion) = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Champion, newItem: Champion) = oldItem.title == newItem.title &&
                oldItem.name == newItem.name &&
                oldItem.lore == newItem.lore

    }
}