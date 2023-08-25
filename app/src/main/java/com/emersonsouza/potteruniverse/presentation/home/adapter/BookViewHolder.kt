package com.emersonsouza.potteruniverse.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.emersonsouza.potteruniverse.databinding.BookItemBinding
import com.emersonsouza.potteruniverse.domain.entity.AttributesEntity

class BookViewHolder(
    private val bookItemBinding: BookItemBinding,
    private val onClickCallback: (book: AttributesEntity) -> Unit,
) : RecyclerView.ViewHolder(bookItemBinding.root) {

    fun bind(atbEntity: AttributesEntity) {
        bookItemBinding.run {
            this.ivBookBanner.load(atbEntity.cover)
            this.tvBookAuthor.text = atbEntity.author
            this.tvBookTitle.text = atbEntity.title
        }

        itemView.setOnClickListener {
            onClickCallback.invoke(atbEntity)
        }
    }

    companion object {
        fun create(
            parent: ViewGroup,
            onClickCallback: (book: AttributesEntity) -> Unit,
        ): BookViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val itemBinding = BookItemBinding.inflate(inflater, parent, false)
            return BookViewHolder(itemBinding, onClickCallback)
        }
    }
}