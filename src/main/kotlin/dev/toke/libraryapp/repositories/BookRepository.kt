package dev.toke.libraryapp.repositories

import dev.toke.libraryapp.models.Book
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : CrudRepository<Book, Long> {
}