package ru.netology.nmedia.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia.Post

class PostRepositoryInMemoryImplementation : PostRepository {
    private var nextId = 1L
    private var posts = listOf(
        Post(
            id = nextId++,
            author = "Нетология. Университет интернет-профессий",
            content = "Привет. Это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия - помочь встать на путь роста и начать цепочку перемен - http://netolo.gy/fyb",
            published = "21 мая в 18:36",
            likes = 1000,
            shares = 999,
            likedByMe = false
        ),
        Post(
            id = nextId++,
            author = "Нетология. Университет интернет-профессий",
            content = "Привет.",
            published = "22 мая в 18:36",
            likes = 999,
            shares = 0,
            likedByMe = false
        ),
        Post(
            id = nextId++,
            author = "Нетология. Университет интернет-профессий",
            content = "Привет. Это новая Нетология!",
            published = "23 мая в 18:36",
            likes = 999,
            shares = 0,
            likedByMe = false
        ),
        Post(
            id = nextId++,
            author = "Нетология. Университет интернет-профессий",
            content = "1234567890",
            published = "24 мая в 18:36",
            likes = 999,
            shares = 0,
            likedByMe = false
        ),
        Post(
            id = nextId++,
            author = "Нетология. Университет интернет-профессий",
            content = "Привет. Это новая Нетология! 1234567890",
            published = "25 мая в 18:36",
            likes = 999,
            shares = 0,
            likedByMe = false
        ),
        Post(
            id = nextId++,
            author = "Нетология. Университет интернет-профессий",
            content = "Привет. Это новая Нетология!  http://netolo.gy/fyb",
            published = "26 мая в 18:36",
            likes = 999,
            shares = 0,
            likedByMe = false
        ),
        Post(
            id = nextId++,
            author = "Нетология. Университет интернет-профессий",
            content = "Привет, Нетология! ",
            published = "27 мая в 18:36",
            likes = 999,
            shares = 0,
            likedByMe = false
        ),
        Post(
            id = nextId++,
            author = "Нетология. Университет интернет-профессий",
            content = "Это новая Нетология!",
            published = "28 мая в 18:36",
            likes = 999,
            shares = 0,
            likedByMe = false
        ),
        Post(
            id = nextId++,
            author = "Нетология. Университет интернет-профессий",
            content = "Нетология!",
            published = "29 мая в 18:36",
            likes = 1000,
            shares = 999,
            likedByMe = false
        )
    )

    private val data = MutableLiveData(posts)

    override fun getAll(): LiveData<List<Post>> = data

    override fun removeById(id: Long) {
        posts = posts.filter {it.id != id}
        data.value = posts
    }

    override fun save(post: Post) {
        if (post.id == 0L) {
            posts = listOf(
                post.copy(
                    id = nextId++,
                    author = "Me",
                    likedByMe = false,
                    published = "now"
                )
            ) + posts
        } else {
            posts = posts.map {
                if (it.id != post.id) it else it.copy(content = post.content)
            }
        }
        data.value = posts
    }

    override fun likeById(id: Long) {
        posts = posts.map {
            if (it.id != id) it else it.copy(
                likedByMe = !it.likedByMe,
                likes = if (it.likedByMe) it.likes - 1 else it.likes + 1
            )
        }
        data.value = posts
    }

    override fun shareById(id: Long) {
        posts = posts.map {
            if (it.id != id) it else it.copy(shares = it.shares + 1)
        }
        data.value = posts
    }
}
