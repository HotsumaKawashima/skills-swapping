package com.android.example.skillsswapping


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.example.skillsswapping.domain.Post
import com.android.example.skillsswapping.domain.User

/**
 * A simple [Fragment] subclass.
 */
class MyPostsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // this is data for recycler view
        val posts = arrayOf(
            Post("post01post01post01post01post01post01post01"),
            Post("post02post02post02post02post02post02post02"),
            Post("post03post03post03post03post03post03post03"),
            Post("post04post04post04post04post04post04post04"),
            Post("post05post05post05post05post05post05post05"),
            Post("post06post06post06post06post06post06post06")
        )

        // Inflate the layout for this fragment
        val rootView:View = inflater.inflate(R.layout.fragment_my_posts, container, false)

        // 1. get a reference to recyclerView
        val recyclerView:RecyclerView = rootView.findViewById(R.id.myPostsRecyclerView)

        // 2. set layoutManger
        recyclerView.layoutManager = LinearLayoutManager(getActivity())

        // 3. set adapter
        recyclerView.adapter = MyPostsAdapter(getActivity(), posts)

        return rootView
    }


}
