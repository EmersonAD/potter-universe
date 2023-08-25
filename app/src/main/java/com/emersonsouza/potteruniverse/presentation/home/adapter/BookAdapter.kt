package com.emersonsouza.potteruniverse.presentation.home.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.emersonsouza.potteruniverse.domain.entity.AttributesEntity
import com.emersonsouza.potteruniverse.domain.entity.DataEntity

class BookAdapter(
    private val onClickLister: (book: AttributesEntity) -> Unit,
) : ListAdapter<DataEntity, BookViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        return BookViewHolder.create(parent, onClickLister)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it.attributes) }
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<DataEntity>() {
            override fun areItemsTheSame(oldItem: DataEntity, newItem: DataEntity): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: DataEntity, newItem: DataEntity): Boolean =
                oldItem == newItem
        }
    }
}