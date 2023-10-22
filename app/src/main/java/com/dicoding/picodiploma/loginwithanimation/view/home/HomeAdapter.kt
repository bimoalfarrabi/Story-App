package com.dicoding.picodiploma.loginwithanimation.view.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.picodiploma.loginwithanimation.databinding.ListStoryBinding
import com.dicoding.picodiploma.loginwithanimation.remote.response.HomeResponse
import com.dicoding.picodiploma.loginwithanimation.remote.response.ListStoryItem

class HomeAdapter :
    ListAdapter<ListStoryItem, HomeAdapter.MyViewHolder>(DIFF_CALLBACK) {

    interface OnItemClickListener {
        fun onItemClick(item: ListStoryItem)
    }

    private var onItemClickListener: OnItemClickListener? = null

    fun SetOnItemClickListener(listener: OnItemClickListener) {
        this.onItemClickListener = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ListStoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val story = getItem(position)
        holder.bind(story)
    }

    inner class MyViewHolder(val binding: ListStoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val story = getItem(position)
                    onItemClickListener?.onItemClick(story)
                }
            }
        }

        fun bind(story: ListStoryItem) {
            binding.storyName.text = story.name
            binding.storyDescription.text = story.description
            binding.storyImage.setImageResource(0)
            Glide.with(binding.storyImage).load(story.photoUrl).into(binding.storyImage)
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ListStoryItem>() {
            override fun areItemsTheSame(
                oldItem: ListStoryItem,
                newItem: ListStoryItem
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: ListStoryItem,
                newItem: ListStoryItem
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}