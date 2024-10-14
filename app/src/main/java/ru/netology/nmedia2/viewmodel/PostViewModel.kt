package ru.netology.nmedia2.viewmodel

import androidx.lifecycle.ViewModel
import ru.netology.nmedia2.repository.PostRepository
import ru.netology.nmedia2.repository.PostRepositoryInMemoryImpl

class PostViewModel : ViewModel() {
    // упрощённый вариант
    private val repository: PostRepository = PostRepositoryInMemoryImpl()
    val data = repository.get()
    fun like() = repository.like()

    fun vievs() = repository.repost()




}