package com.emersonsouza.potteruniverse.presentation.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.TypedArrayUtils.getString
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.emersonsouza.potteruniverse.R
import com.emersonsouza.potteruniverse.databinding.BookItemBinding
import com.emersonsouza.potteruniverse.domain.entity.AttributesEntity

class BookViewHolder(
    private val bookItemBinding: BookItemBinding,
    private val onClickCallback: (cardView: View, book: AttributesEntity) -> Unit,
) : RecyclerView.ViewHolder(bookItemBinding.root) {

    fun bind(atbEntity: AttributesEntity) {
        bookItemBinding.run {
            ivBookBanner.load(atbEntity.cover)
            tvBookAuthor.text = atbEntity.author
            tvBookTitle.text = atbEntity.title
            ViewCompat.setTransitionName(cardView, "card_book_name_${atbEntity.title}")
        }

        itemView.setOnClickListener {
            onClickCallback.invoke(bookItemBinding.cardView, atbEntity)
        }
    }

    companion object {
        fun create(
            parent: ViewGroup,
            onClickCallback: (cardView: View, book: AttributesEntity) -> Unit,
        ): BookViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val itemBinding = BookItemBinding.inflate(inflater, parent, false)
            return BookViewHolder(itemBinding, onClickCallback)
        }
    }
}