package com.android.example.skillsswapping

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.example.skillsswapping.domain.Post

class MyPostsAdapter(val context: FragmentActivity?) : ListAdapter<Post, MyPostsAdapter.MyPostsViewHolder>(DiffCallback()) {

    var posts: List<Post> = emptyList()

//    var posts: List<Post> = listOf(
//        Post("01", "post01post01post01post01post01post01post01")
//    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPostsViewHolder {
        val itemView = LayoutInflater
            .from(context)
            .inflate(R.layout.list_item_my_post, parent, false)
        return MyPostsViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: MyPostsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    // ViewHolder
    class MyPostsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val postDescriptionTxt: TextView = itemView.findViewById(R.id.postDescriptionTxt)

        fun bind(item: Post) {
            postDescriptionTxt.text = item.description
        }
    }

    override fun submitList(list: List<Post>?) {
        super.submitList(list)
        println("submitList is called & list is $list")
    }

    class DiffCallback : DiffUtil.ItemCallback<Post>() {
        override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
            println("DiffCallback")
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem.id == newItem.id
        }
    }
}

