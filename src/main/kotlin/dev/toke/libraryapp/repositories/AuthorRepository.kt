package dev.toke.libraryapp.repositories

import dev.toke.libraryapp.models.Author
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthorRepository : CrudRepository<Author, Long> {
}