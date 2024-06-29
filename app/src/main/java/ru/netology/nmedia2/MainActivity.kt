package ru.netology.nmedia2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import ru.netology.nmedia2.databinding.ActivityMainBinding
import ru.netology.nmedia2.dto.Post

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val post = Post(
            id = 1,
            author = "Нетология. Университет интернет-профессий будущего",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
            published = "21 мая в 18:36",
            likedByMe = false


        )

        with(binding) {

            author.text = post.author
            published.text = post.published
            text.text = post.content
            ViewsCounter.text = toStringCount(post.vievs)
            likeCounter?.text = toStringCount(post.likes)

            if (post.likedByMe) {
                likeImg?.setImageResource(R.drawable.baseline_favorite_border_24)
            }



            likeImg?.setOnClickListener {
                Log.d("stuff", "like")
                post.likedByMe = !post.likedByMe
                likeImg.setImageResource(
                    if (post.likedByMe) R.drawable.baseline_favorite_24 else R.drawable.baseline_favorite_border_24
                )
                if (post.likedByMe) post.likes++ else post.likes--
                likeCounter?.text = toStringCount(post.likes)

            }
            ViewsImg.setOnClickListener{
                post.vievs++
                ViewsCounter.text = toStringCount(post.vievs)
            }

        }
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