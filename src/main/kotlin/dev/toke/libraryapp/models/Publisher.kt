package dev.toke.libraryapp.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.*

@Entity
@Table(name = "publishers")
data class Publisher(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,
    var name: String,
    var address: String?,
    var city: String?,
    var state: String?,
    var postcode: String?,
    var website: String,

    @OneToMany(mappedBy = "publisher")
    @JsonIgnoreProperties("publisher")
    var books: MutableSet<Book> = mutableSetOf()
)
