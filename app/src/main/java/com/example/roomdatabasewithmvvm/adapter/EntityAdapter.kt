package com.example.roomdatabasewithmvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.roomdatabasewithmvvm.R
import com.example.roomdatabasewithmvvm.data.models.ResponseEntity


class EntityAdapter(private var entity: List<ResponseEntity>, private val onItemClick: OnItemClick) :
    RecyclerView.Adapter<EntityAdapter.EntityViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntityViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.entity_item_layout, parent, false)
        return EntityViewHolder(view)
    }

    override fun onBindViewHolder(holder: EntityViewHolder, position: Int) {

        Glide.with(holder.view)
            .load(entity[position].image)
            .into(holder.mIvItemImage)

        holder.mTvItemTitle.text = entity[position].title
        holder.mTvItemSubTitle.text = entity[position].subTitle

        holder.itemView.setOnClickListener {
            onItemClick.onEntityItemClicked(position)
        }
    }

    override fun getItemCount(): Int {
        return entity.size
    }

    fun filteredList(tempList: MutableList<ResponseEntity>) {
        entity = tempList
        notifyDataSetChanged()
    }

    class EntityViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        val mIvItemImage: ImageView = view.findViewById(R.id.ivItemImage)
        val mTvItemTitle: TextView = view.findViewById(R.id.tvItemTitle)
        val mTvItemSubTitle: TextView = view.findViewById(R.id.tvItemSubTitle)

    }
}