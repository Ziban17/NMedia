package ru.netology.nmedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import ru.netology.nmedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val post = Post(
            id = 1,
            author = "Нетология. Университет интернет-профессий",
            content = "Привет. Это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия - помочь встать на путь роста и начать цепочку перемен - http://netolo.gy/fyb",
            published = "21 мая в 18:36",
            likes = 999_999,
            shares = 999,
            likedByMe = false
        )
        binding.apply {
            author.text = post.author
            published.text = post.published
            content.text = post.content
            likesCount?.text = post.countRound(post.likes)
            shareCount.text = post.countRound(post.shares)
            if (post.likedByMe) {
                like.setImageResource(R.drawable.ic_liked_24)
            }

            root.setOnClickListener {
                Log.d("stuff", "stuff")
            }
            avatar.setOnClickListener {
                Log.d("stuff", "avatar")
            }

            like.setOnClickListener {
                Log.d("stuff", "like")
                post.likedByMe = !post.likedByMe
                like.setImageResource(
                    if (post.likedByMe) R.drawable.ic_liked_24 else R.drawable.ic_like_24
                )
                if (post.likedByMe) post.likes++ else post.likes--
                likesCount?.text = post.countRound(post.likes)
            }

            share.setOnClickListener{
                Log.d("stuff", "share")
                post.shares++
                shareCount?.text = post.countRound(post.shares)
            }
        }
    }
}
