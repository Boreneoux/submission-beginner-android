package com.boreneoux.submissionmoviebeginnerandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.boreneoux.submissionmoviebeginnerandroid.databinding.ActivityAboutBinding
import com.boreneoux.submissionmoviebeginnerandroid.databinding.ActivityDetailMovieBinding
import com.bumptech.glide.Glide

class AboutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            Glide.with(this@AboutActivity)
                .load(R.drawable.about_photo)
                .circleCrop()
                .into(imgAboutProfile);
        }
    }

}