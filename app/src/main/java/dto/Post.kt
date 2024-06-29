package ru.netology.nmedia2.dto

data class Post(
    val id: Long,
    val author: String,
    val content: String,
    val published: String,
    var likes: Int = 1500,
    var likedByMe: Boolean = false,
    var vievs: Int = 1234565
)