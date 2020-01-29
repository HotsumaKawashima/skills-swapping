package com.android.example.skillsswapping

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.example.skillsswapping.domain.Post

class MyPostsViewModel: ViewModel(){

    var posts = MutableLiveData<List<Post>>( listOf(
        Post("01", "post01post01post01post01post01post01post01"),
        Post("02", "post02post02post02post02post02post02post02"),
        Post("03", "post03post03post03post03post03post03post03"),
        Post("04", "post04post04post04post04post04post04post04")
    ) )

    fun getPosts(): LiveData<List<Post>> {
        return posts
    }
}