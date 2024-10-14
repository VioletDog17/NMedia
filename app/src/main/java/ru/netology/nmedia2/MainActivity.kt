package ru.netology.nmedia2

import android.os.Bundle
import android.util.Log
import ru.netology.nmedia2.R
import androidx.appcompat.app.AppCompatActivity
import ru.netology.nmedia2.databinding.ActivityMainBinding
import ru.netology.nmedia2.viewmodel.PostViewModel
import androidx.activity.viewModels
import androidx.lifecycle.viewModelScope

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Из-за изменения расположения кнопок оченьзапутаны названия вьюшек репост это просмотры а просмотры это репосты. Копец

        val viewModel: PostViewModel by viewModels()
        viewModel.data.observe(this) { post ->
            with(binding) {

                author.text = post.author
                published.text = post.published
                text.text = post.content
                likeCounter.text =  toStringCount (post.likes)
                shereCounter.text = toStringCount(post.vievs)
                ViewsCounter.text = toStringCount (post.repost)
                likeImg.setImageResource(
                    if (post.likedByMe) (R.drawable.baseline_favorite_border_24) else R.drawable.baseline_favorite_24
                )

            }
        }
        binding.likeImg.setOnClickListener {
            viewModel.like()
        }

        binding.ViewsImg.setOnClickListener {
            viewModel.vievs()
        }
    }
    fun toStringCount(y : Int): String {
        var ans : String
        if (y<=999){
            return y.toString()
        }
        var x = y.toDouble()
        ans = x.toString()
        if ((x > 999) and (x <= 999_999)) {
            ans = (Math.round((x / 1000) * 10.0) / 10.0).toString() + "K"
        }
        if (x > 999999){
            ans = (Math.round((x / 1000000) * 10.0) / 10.0).toString() + "M"
        }
        return ans
    }
}





