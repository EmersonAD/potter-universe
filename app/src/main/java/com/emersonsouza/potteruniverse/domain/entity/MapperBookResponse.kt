package com.emersonsouza.potteruniverse.domain.entity

import com.emersonsouza.potteruniverse.data.model.book.Attributes
import com.emersonsouza.potteruniverse.data.model.book.Data

object MapperBookResponse {
    fun List<Data>.convertToEntityList() = this.map {
        DataEntity(
            id = it.id,
            attributes = it.attributes.toEntity()
        )
    }

    private fun Attributes.toEntity(): AttributesEntity {
        return AttributesEntity(
            author = this.author,
            order = this.order,
            pages = this.pages,
            releaseDate = this.releaseDate,
            summary = this.summary,
            title = this.title,
            cover = this.cover,
            wiki = this.wiki
        )
    }
}