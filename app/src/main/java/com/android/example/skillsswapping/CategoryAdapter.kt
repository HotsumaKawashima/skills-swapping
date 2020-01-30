package com.android.example.skillsswapping

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.android.example.skillsswapping.database.Service

class CategoryAdapter(private val service: Array<Service>, private val listener: OnItemClickListener) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(item: View?, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.list_item_service, parent, false)
        return CategoryViewHolder(itemView, listener)
    }

    override fun getItemCount(): Int {
        return 3
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.txtDescription.text = service.get(position).description
    }

    class CategoryViewHolder(itemView: View, private val listener: OnItemClickListener) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var txtDescription: TextView = itemView.findViewById(R.id.postDescriptionTxt)
        var constraintDetailItem: ConstraintLayout =
            itemView.findViewById(R.id.constraintDetailItem)

        init {
            constraintDetailItem.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            when (v?.id) {
                R.id.constraintDetailItem -> listener.onItemClick(v, adapterPosition)
            }
        }
    }
}