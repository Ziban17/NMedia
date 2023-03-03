package ru.netology.nmedia
import kotlin.math.roundToInt

data class Post(
    val id: Long,
    val author: String,
    val content: String,
    val published: String,
    val likes: Int = 0,
    val shares: Int = 0,
    val likedByMe: Boolean = false
) {
    fun countRound(count: Int): String {
        return when (count) {
            in 0..999 -> count.toString()
            in 1000..1_099 -> {(count / 1000).toString() + "K"
            }
            in 1100..9_999 -> {
                var text = (count.toDouble() / 1000)
                text = (text * 10).roundToInt() / 10.0
                text.toString() + "K"
            }
            in 10_000..999_999 -> {val text = (count / 1000)
                text.toString() + "K"
            }
            in 1_000_000..1_099_999 -> {val text = (count / 1_000_000)
                text.toString() + "M"
            }
            else -> {var text = (count.toDouble() / 1_000_000)
                text = (text * 10).roundToInt() / 10.0
                text.toString() + "M"
            }
        }
    }
}
