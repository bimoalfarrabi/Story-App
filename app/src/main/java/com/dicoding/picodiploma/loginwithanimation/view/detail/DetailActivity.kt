package com.dicoding.picodiploma.loginwithanimation.view.detail

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.dicoding.picodiploma.loginwithanimation.databinding.ActivityDetailBinding
import com.dicoding.picodiploma.loginwithanimation.remote.response.ListStoryItem
import com.dicoding.picodiploma.loginwithanimation.view.home.HomeAdapter

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var adapter: HomeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = HomeAdapter()


        val detailStory = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<ListStoryItem>(DETAIL_STORY) as ListStoryItem
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<ListStoryItem>(DETAIL_STORY) as ListStoryItem
        }
        storyData(detailStory)
    }

    private fun storyData(storyItem: ListStoryItem) {
        binding.tvStoryName.text = storyItem.name
        binding.tvStoryDescription.text = storyItem.description
        binding.imgStoryPhoto.setImageResource(0)
        Glide.with(binding.imgStoryPhoto).load(storyItem.photoUrl).into(binding.imgStoryPhoto)
    }

    companion object {
        private const val TAG = "DetailActivity"
        const val DETAIL_STORY = "detail_story"
    }
}