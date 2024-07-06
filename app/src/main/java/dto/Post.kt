package ru.netology.nmedia2.dto

data class Post(
    val id: Long,
    val author: String,
    val content: String,
    val published: String,
    val likes: Int,
    val likedByMe: Boolean,
    val vievs: Int,
    val repost: Int

)