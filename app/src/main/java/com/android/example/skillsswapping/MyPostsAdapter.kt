package com.android.example.skillsswapping

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.example.skillsswapping.database.Service

class MyPostsAdapter(val context: FragmentActivity?) : ListAdapter<Service, MyPostsAdapter.MyPostsViewHolder>(DiffCallback()) {

    var services: List<Service> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPostsViewHolder {
        val itemView = LayoutInflater
            .from(context)
            .inflate(R.layout.list_item_my_post, parent, false)
        return MyPostsViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return services.size
    }

    override fun onBindViewHolder(holder: MyPostsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    // ViewHolder
    class MyPostsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val postDescriptionTxt: TextView = itemView.findViewById(R.id.postDescriptionTxt)

        fun bind(item: Service) {
            postDescriptionTxt.text = item.description
        }
    }

    fun updateList(list: List<Service>) {
        services = list
        submitList(list)
        println("submitList is called & list is $list")
    }

    class DiffCallback : DiffUtil.ItemCallback<Service>() {
        override fun areItemsTheSame(oldItem: Service, newItem: Service): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Service, newItem: Service): Boolean {
            return oldItem.id == newItem.id
        }
    }
}

