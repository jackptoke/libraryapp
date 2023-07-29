package dev.toke.libraryapp.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.*

@Entity
@Table(name = "books")
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,
    var title: String,
    var isbn: String,
    var description: String?,
    @ManyToMany //(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinTable(name = "author_book", joinColumns = [JoinColumn(name="book_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "author_id", referencedColumnName = "id")]
    )
    @JsonIgnoreProperties("books")
    var authors: MutableSet<Author> = mutableSetOf(),

    @ManyToOne
    var publisher: Publisher
) {
    override fun equals(o: Any?): Boolean {
        if(this == o) return  true
        if(o !is Book) return false

        return !(title != o.title || isbn != o.isbn || description != o.description || id != o.id)
    }

    override fun hashCode(): Int = id?.hashCode() ?: 0

    override fun toString(): String = "Author{ id=$id, title=$title, isbn=$isbn, description=$description }"
}
