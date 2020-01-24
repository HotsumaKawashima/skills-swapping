package com.android.example.skillsswapping

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.android.example.skillsswapping.domain.Post

class MyPostsAdapter(val context: FragmentActivity?, val posts: Array<Post>) : RecyclerView.Adapter<MyPostsAdapter.MyPostsViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPostsViewHolder {
       val itemView = LayoutInflater
           .from(context)
           .inflate(R.layout.list_item_my_post, parent,false)
        return MyPostsViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: MyPostsViewHolder, position: Int) {
       val user = posts[position]
        holder.bind(user)
    }

    // ViewHolder
    class MyPostsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val postDescriptionTxt: TextView = itemView.findViewById(R.id.postDescriptionTxt)

        fun bind(item: Post) {
            postDescriptionTxt.text = item.description
        }
    }
}