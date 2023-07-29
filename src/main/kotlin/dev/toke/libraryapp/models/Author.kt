package dev.toke.libraryapp.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table

@Entity
@Table(name = "authors")
data class Author(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,
    var firstName: String,
    var lastName: String,
    @ManyToMany(mappedBy = "authors")
    @JsonIgnoreProperties("authors")
    val books: MutableSet<Book> = mutableSetOf()
)
{
    override fun equals(o: Any?): Boolean {
        if(this == o) return  true
        if(o !is Author) return false

        return !(firstName != o.firstName || lastName != o.lastName || id != o.id)
    }

    override fun hashCode(): Int = id?.hashCode() ?: 0

    override fun toString(): String = "Author{ id=$id, firstName=$firstName, lastName=$lastName, books=$books }"
}
