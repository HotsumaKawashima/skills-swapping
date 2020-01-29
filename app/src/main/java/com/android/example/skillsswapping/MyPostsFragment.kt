package com.android.example.skillsswapping


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.example.skillsswapping.domain.Post

/**
 * A simple [Fragment] subclass.
 */
class MyPostsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val rootView:View = inflater.inflate(R.layout.fragment_my_posts, container, false)

        // 1. get a reference to recyclerView
        val recyclerView:RecyclerView = rootView.findViewById(R.id.myPostsRecyclerView)

        // 2. set layoutManger
        recyclerView.layoutManager = LinearLayoutManager(getActivity())

        val model: MyPostsViewModel by viewModels()
        val myPostsAdapter:MyPostsAdapter? = MyPostsAdapter(getActivity())

        model.getPosts().observe(this, Observer<List<Post>>{posts->
                println("observe method is called $ posts is $posts")
                myPostsAdapter?.submitList(posts)
        })

        // 3. set adapter
        recyclerView.adapter = myPostsAdapter

        return rootView
    }

}