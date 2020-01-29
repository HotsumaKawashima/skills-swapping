package com.android.example.skillsswapping

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.example.skillsswapping.domain.Post

class CategoryAdapter(val post: Array<Post>) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.list_item_service, parent, false)
        return CategoryViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return 4
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.txtDescription.text = post.get(position).description
    }

    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var txtDescription:TextView = itemView.findViewById(R.id.postDescriptionTxt)
    }
}